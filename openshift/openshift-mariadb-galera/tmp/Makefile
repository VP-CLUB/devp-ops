IMAGE_NAME=openshift/mariadb-galera-centos
IMAGE_VERSION=1.0.0
LOCAL_REGISTRY=docker-registry-default.172.16.5.80.nip.io

image:
	docker build -t $(IMAGE_NAME):$(IMAGE_VERSION) .

push:
	docker tag $(IMAGE_NAME):$(IMAGE_VERSION) $(LOCAL_REGISTRY)/$(IMAGE_NAME):$(IMAGE_VERSION)
	docker push $(LOCAL_REGISTRY)/$(IMAGE_NAME):$(IMAGE_VERSION)
