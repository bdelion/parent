# Changelog
All notable changes to this project will be documented in this file.

<a name="0.9.2"></a>

## [0.9.2-SNAPSHOT](https://github.com/lars-sh/parent/compare/3547b85c9a72fd0c10c00be9dd40ceee65fec7cf...master)

Download at TODO

### Added
* Archetype
* Changelog
* Annotation de.larssh.utils.annotations.PackagePrivate
* Class de.larssh.utils.maven.DependencyScope
* Class de.larssh.utils.net.GlobalProxyConfiguration
* Method de.larssh.utils.Optionals.getFirst(isPresent, suppliers)
* Method de.larssh.utils.Optionals.getFirstValue(isPresent, values)
* Method de.larssh.utils.Optionals.ofNonEmpty(array|collection)
* Method de.larssh.utils.Optionals.ofSingle(array|collection|iterator|stream|string)

### Changed
* Execute SpotBugs, copy-paste-detection (CPD) and dependency analysis from Maven reporting to build phase
* Moved de.larssh.utils.AetherUtils to de.larssh.utils.maven.AetherUtils
* ParseException initializes cause
* Checkstyle suppressions file name changed from "suppressions.xml" to "checkstyle-suppressions.xml"
* Checkstyle for unit tests suppresses checks ExecutableStatementCountCheck, MagicNumberCheck and MethodLengthCheck
* Validate Javadoc inside Travis CI
* Update dependencies and Maven plugins

### Fixed
* Maven plugins were not compatible with Maven versions unequal to 3.6.0

<a name="0.9.1"></a>

## [0.9.1](https://github.com/lars-sh/parent/compare/55696d71cc8c2946710a803945c0425967e4e83c...3547b85c9a72fd0c10c00be9dd40ceee65fec7cf) (2018-12-12)

Download at [Maven Search](https://search.maven.org/search?q=g:de.lars-sh%20AND%20%28a:parent%20a:root%20a:utils%20a:utils-annotations%20a:utils-test%29%20AND%20v:0.9.1)

### Fixed
* Handling of parent projects module version

<a name="0.9.0"></a>

## [0.9.0](https://github.com/lars-sh/parent/commit/55696d71cc8c2946710a803945c0425967e4e83c) (2018-12-10)

Download at [Maven Search](https://search.maven.org/search?q=g:de.lars-sh%20AND%20%28a:parent%20a:root%20a:utils%20a:utils-annotations%20a:utils-test%29%20AND%20v:0.9.0)

* Initial release