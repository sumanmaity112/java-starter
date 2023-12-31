# Java Starter

Getting a new Java and Gradle project off the ground quickly.

---

## Table of contents

- [Features](#features)
- [Prerequisites](#prerequisites)
- [Verifications](#verifications)
- [Formatting](#formatting)
- [Security Checks](#security-checks)
- [License Checks](#license-checks)
  - [Generate License Report](#generate-license-report)
  - [Validate Licences](#validate-licences)
- [Commits](#commits)
  - [Types](#types)
- [Release new version](#release-new-version)

## Features

The following are included in this repository:

- Provides lint, [OWASP](https://owasp.org/) dependency checking, and [Gradle](https://gradle.org/) setup for Java projects.
- Contains GitHub action Workflows for writing code and performing security audits.
- Manages Java patches and GitHub actions via Dependabot.
- Generate and validate licenses reports for dependencies.
- Updates the Gradle wrapper using [gradle-update/update-gradle-wrapper-action](https://github.com/gradle-update/update-gradle-wrapper-action)
  > [!NOTE]\
  > If you are facing `Error: Github Actions is not permitted to create pull request.`, then please check [GitHub action permission settings](https://github.com/orgs/community/discussions/27689).
- To implement automatic version management, use conventional commits.
  > [!NOTE]\
  > You need to create the following [pull request labels](https://docs.github.com/en/issues/using-labels-and-milestones-to-track-work/managing-labels) to make sure patch management works properly
  >
  > - dependabot
  > - dependencies
  > - java
  > - github-actions
  > - gradle

## Prerequisites

- Java 17

## Verifications

To run all the verifications:

```shell script
./gradlew clean check
```

## Formatting

This project uses the following tools to follow specific style guide

- [spotless](https://github.com/diffplug/spotless) for **Java** files

To run format:

```shell script
./gradlew spotlessJavaApply
```

## Security Checks

This project uses the following tools to find security vulnerabilities

- [org.owasp.dependencycheck](https://plugins.gradle.org/plugin/org.owasp.dependencycheck) to find vulnerable
  dependencies

To run OWASP dependency check:

```shell script
./gradlew clean dependencyCheckAnalyze
```

## License Checks

This project uses [com.github.jk1.dependency-license-report](https://github.com/jk1/Gradle-License-Report) to validate licenses for dependencies.

### Generate License Report

To generate license report:

```shell
./gradlew generateLicenseReport
```

### Validate Licences

To validate licenses for dependencies:

```shell
./gradlew checkLicense
```

> [!NOTE]\
> Allowed licenses are present at [allowedLicence.json](https://github.com/sumanmaity112/java-starter/blob/main/gradle/config/allowedLicence.json).

## Commits

This repository follows [Conventional Commits](https://www.conventionalcommits.org/en/v1.0.0/). Therefor whenever you
are
committing the changes make sure to use proper **type**.

### Types

- **feat** for a new feature for the user, not a new feature for build script. Such commit will trigger a release
  bumping a MINOR version.
- **fix** for a bug fix for the user, not a fix to a build script. Such commit will trigger a release bumping a PATCH
  version.
- **chore** for Update something without impacting the user (ex: bump a dependency in package.json).
- **perf** for performance improvements. Such commit will trigger a release bumping a PATCH version.
- **docs** for changes to the documentation.
- **style** for formatting changes, missing semicolons, etc.
- **refactor** for refactoring production code, e.g. renaming a variable.
- **test** for adding missing tests, refactoring tests; no production code change.
- **build** for updating build configuration, development tools or other changes irrelevant to the user.

> [!NOTE]\
> Add **!** just after type to indicate breaking changes

## Release new version

To publish a new version to GitHub Packages follow the following steps:

- Create a new release version by running following command

```shell
./gradlew tag -Prelease -Dmessage="$(git log -1 --format=%s)"
```

- Push the newly created **tag** to GitHub

```shell
git push origin "$(git describe --tags)"
```

> [!NOTE]\
> We are following [semantic versioning](https://semver.org/) strategy
> using [io.alcide:gradle-semantic-build-versioning](https://github.com/alcideio/gradle-semantic-build-versioning) plugin
