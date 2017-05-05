IMAGE_NAME=adfinissygroup/k8s-mariadb-galera-centos
IMAGE_VERSION=v002
LOCAL_REGISTRY=docker-registry-default.172.16.5.80.nip.io

image:
	docker build -t $(IMAGE_NAME):$(IMAGE_VERSION) .

push:
	docker tag $(IMAGE_NAME):$(IMAGE_VERSION) $(LOCAL_REGISTRY)/$(IMAGE_NAME):$(IMAGE_VERSION)
	docker push $(LOCAL_REGISTRY)/$(IMAGE_NAME):$(IMAGE_VERSION)
