# ECM3432-2021-minsky

## A software engineering exercise

~~<https://travis-ci.com/github/ExeterBScDTS/ECM3432-2021-minsky>~~

Travis CI:

<https://travis-ci.com/github/ECM3432-A/ECM3432-2021-minsky>

[![Build Status](https://travis-ci.com/ECM3432-A/ECM3432-2021-minsky.svg?branch=main)](https://travis-ci.com/ECM3432-A/ECM3432-2021-minsky)

![robot picture](minsky.jpg "I can help")

## Building

To run the backend of this application:

Run ```yarn main``` from the top level directory of the project

To run the front end of this application:

Run ```yarn frontend``` at the top level directory of this project.

* If you want to make changes to the front end, you will need to run front end first
then main.

## Consider also

```sh
cd minsky-gatsby
yarn build
```

```sh
cd minsky-one
mvn compile
mvn package
```

## Check builds

<https://travis-ci.com/github/ExeterBScDTS/ECM3432-2020-minsky>

## To create a release

To generate a new release via Travis CI create a tag

```sh
git tag -a v0.1.x -m "v0.1.x"
git push origin v0.1.x
```

### Set-up

To use GitHub releases a GitHub personal API token. See <https://github.com/settings/tokens>

Once you have a token use 

```sh
# cd to project folder with .travis.yml file
travis encrypt GITHUB_TOKEN=<THETOKEN> -add --com
```

This will update ```.travis.yml``` with an encrypted copy of the token.  

If the travis tools aren't installed use ```gem install travis --no-document --user-install```

This blog post is a useful reference <https://p5v.medium.com/using-travis-for-secure-building-and-deployment-to-github-5a97afcac113>


## Runtime

The settings database is loaded at start-up.  This is achieved using ```<load-on-startup>```

## Deployment

Adding the update feature created some issues.

```text
HTTP ERROR 500 java.lang.NoClassDefFoundError: org/apache/http/protocol/HttpContext
URI:	/update
STATUS:	500
MESSAGE:	java.lang.NoClassDefFoundError: org/apache/http/protocol/HttpContext
SERVLET:	update
CAUSED BY:	java.lang.NoClassDefFoundError: org/apache/http/protocol/HttpContext
CAUSED BY:	java.lang.ClassNotFoundException: org.apache.http.protocol.HttpContext
```

This was resolved by including library jars in the war file.  See ```pom.xml```


