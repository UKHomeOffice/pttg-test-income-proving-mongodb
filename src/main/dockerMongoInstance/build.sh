#!/usr/bin/env bash
set -e
[ -n "$DEBUG" ] && set -x

setup() {
	echo "build number:: " ${BUILD_NUMBER}
	VERSION_NUMBER=0.1.0
}

cleanup() {
	CONTAINERS=$(docker ps -aq)

	if [ ! -z "$CONTAINERS" -a "$CONTAINERS" != " " ]; then
		docker stop $CONTAINERS
		docker rm $CONTAINERS
	fi

	IMAGES=$(docker images | grep pttg-family-migration-api-build | awk '{print $3'})

	if [ ! -z "$IMAGES" -a "$IMAGES" != " " ]; then
		docker rmi -f $IMAGES
	fi
}


buildDockerAppExecutionImage() {
	echo "build docker image for app::"
	#TAG="quay.io/ukhomeofficedigital/uk.gov.digital.ho.proving.income.api:${VERSION_NUMBER}.${BUILD_NUMBER}"
	if [[ -n ${BUILD_NUMBER} ]]; then
		TAG="quay.io/ukhomeofficedigital/pttg-test-mongodb:${VERSION_NUMBER}.${BUILD_NUMBER}"
	else
		TAG="quay.io/ukhomeofficedigital/pttg-test-mongodb:${VERSION_NUMBER}"
	fi
	echo "building " ${TAG}
	docker build -t ${TAG} .
}

pushImageToRepo() {
	docker push ${TAG}
}

# -----
# Build
# -----


setup
buildDockerAppExecutionImage
pushImageToRepo

