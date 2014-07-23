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
      --tags http-server \
      --address 146.148.2.77

* List images::

    gcutil listinstances

* SSH into image::

    gcloud compute ssh --zone europe-west1-a bootiful-img

* Delete image::

    gcloud compute instances delete --zone europe-west1-a bootiful-img