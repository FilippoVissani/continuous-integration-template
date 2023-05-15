const config = require('semantic-release-preconfigured-conventional-commits')
const verifyReleaseCommands = `
sed -i 's/ThisBuild / version :=.*/ThisBuild / version := "\${nextRelease.version}"/g' build.sbt || exit 1
git add -A || exit 2
git commit -m "chore: [skip ci] update version in build.sbt" || exit 3
sbt publishSigned sonatypePrepare sonatypeBundleUpload sonatypeClose sonatypeDrop || exit 3
`
const prepareCommands = `
sed -i 's/ThisBuild / version :=.*/ThisBuild / version := "\${nextRelease.version}"/g' build.sbt || exit 1
git add -A || exit 2
git commit -m "chore: [skip ci] update version in build.sbt" || exit 3
git push --force origin || exit 4
`
const publishCommands = `
sbt assembly
git tag -a -f \${nextRelease.version} \${nextRelease.version} -F CHANGELOG.md || exit 1
git push --force origin \${nextRelease.version} || exit 2
sbt publishSigned sonatypeBundleRelease || exit 3
`
const releaseBranches = ["main"]
config.branches = releaseBranches
config.plugins.push(
    ["@semantic-release/exec", {
        "prepareCmd": prepareCommands,
        "publishCmd": publishCommands,
        "verifyReleaseCmd": verifyReleaseCommands,
    }],
    ["@semantic-release/github", {
        "assets": [
            { "path": "/target/scala-3.2.2/*.jar" },
        ]
    }],
    ["@semantic-release/git", {
        "assets": ["CHANGELOG.md", "package.json"],
        "message": "chore(release)!: [skip ci] ${nextRelease.version} released"
    }],
)
module.exports = config