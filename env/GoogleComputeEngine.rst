========================================
Google Compute Engine and Docker
========================================

* Create project::

    gcloud config set project bootiful-todo-app

* List Docker container::

    gcloud compute images list --project google-containers

* Create image instance::

    gcloud compute instances create bootiful-img \
      --image container-vm-v20140710 \
      --image-project google-containers \
      --zone europe-west1-a \
      --machine-type f1-micro \
      --tags http-server https-server \
      --address 146.148.3.93 \
      --no-boot-disk-auto-delete \
      --disk name=bootiful-img boot=yes

* Create with existing device::

    gcloud compute instances create bootiful-img \
      --image-project google-containers \
      --zone europe-west1-a \
      --machine-type f1-micro \
      --tags http-server https-server \
      --address 146.148.3.93 \
      --disk name=bootiful-img boot=yes


* List images::

    gcutil listinstances

* SSH into image::

    gcloud compute ssh --zone europe-west1-a bootiful-img

* Delete image::

    gcloud compute instances delete --zone europe-west1-a bootiful-img

* Register network address::

    gcutil reserveaddress --project=bootiful-todo-app --region=europe-west1  bootiful-apps-network
