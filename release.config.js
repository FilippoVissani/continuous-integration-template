const config = require('semantic-release-preconfigured-conventional-commits')
const publishCommands = `
git tag -a -f v\${nextRelease.version} v\${nextRelease.version} -F CHANGELOG.md  || exit 1
git push --force origin v\${nextRelease.version} || exit 4
sbt ci-release || exit 3
`
const releaseBranches = ["main"]
config.branches = releaseBranches
config.plugins.push(
    ["@semantic-release/exec", {
        "publishCmd": publishCommands,
    }],
    ["@semantic-release/github", {
        "assets": [
            { "path": "build/shadow/*.jar" },
        ]
    }],
    ["@semantic-release/git", {
        "assets": ["CHANGELOG.md", "package.json"],
        "message": "chore(release)!: [skip ci] ${nextRelease.version} released"
    }],
)
module.exports = config