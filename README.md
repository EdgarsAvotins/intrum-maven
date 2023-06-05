Run tests with `mvn clean test -e -Dtest=testRunner.ParallelTestRunner`

Dockerfile add `--platform=linux/amd64` for M1 chips.
Build docker with `docker build -t javamvn .`
To start up docker and run tests use `docker run --name java-mvn --rm -it javamvn mvn test -e -Dtest=testRunner.ParallelTestRunner`
Or just `docker run --name java-mvn --rm -it javamvn /bin/bash` and it's alive until you get out of there.