# Strangler Fig Pattern Demo @ DevBcn 🇪🇸 2023

### **0. Prerequisite**

This demo scenario for showcasing the strangler fig pattern **requires access to a Kubernetes cluster**. In case you neither have any locally available k8s environment on your development machine (e.g. `minikube`) nor a Kubernetes cluster playground at your disposal you can can **claim your personal, managed [OpenShift Developer Sandbox](https://red.ht/sandbox4all) free of charge for 30 days.**

### **1. Login to k8s / configure `kubectl`**

Make sure to login / authenticate to the Kubernetes cluster you want to use for running this demo scenario.
Also verify that your `kubectl` is properly configured and points to the cluster in question.

### **2. Run the demo scenario**

#### **2.1 basic example**

Check that you are on the `basic-example` branch of this repository. If not, run `git checkout basic-example` to switch to this particular branch.

In the root directory you find a bash script which `run-sfp-demo.sh`. Run this script to execute all the demo steps one by one.

#### **2.1 enhanced example**

Check that you are on the `enhanced-example` branch of this repository. If not, run `git checkout enhanced-example` to switch to this particular branch.

In the root directory you find a bash script which `run-sfp-demo.sh`. Run this script to execute all the demo steps one by one.
