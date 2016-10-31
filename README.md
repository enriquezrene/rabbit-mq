# SpringBoot and RabbitMQ integration

In order to get up-and-runnig please install docker-compose:

On Ubuntu 14.04 follow this instructions:

```sh
# Install docker
wget -qO- https://get.docker.com/ | sh
# Add your user to the docker group
sudo usermod -aG docker $(whoami)
# Log out and log in from your server to activate your new groups. Then, install python-pip
sudo apt-get -y install python-pip
# Finally, install docker-compose
sudo pip install docker-compose
```

From the root of this project in your terminal type:

```sh
# Start your docker image with RabbitMQ installed
docker-compose up
```

From your preferred IDE run *RabbitMqApplication.java* class (Of course, you can run the jar, take in mind that this one is a spring-boot application)

Now, you will have one endpoint exposed to send messages and a Listener ready to print in the console, any message that you wanna send, in order to send a message use this CURL command:

```
curl -X POST -H "Content-Type: application/json" -d 'Hi there'  http://localhost:8080/producer
```

You will see in the console:
```
Received <Hi there>
```