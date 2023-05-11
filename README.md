Application is running on port 8000
Together with a mongodb instance

To run in docker containers  via a network called mynetwork:
docker network create mynetwork
docker run -p 27017:27017 --name mymongo --network-alias mymongo --network mynetwork -d mongo:latest
docker run -d --name postservice --network mynetwork -p 8000:8000 postservice:latest

dockerfile is available on
https://hub.docker.com/r/jonathanjonathan001/postservice
docker pull jonathanjonathan001/postservice:latest

URL is /posts for POST and GET
JSON format for POST:
{
"fromUsername": "kalle",
"toUsername": "martin",
"message": "This is a message"
}

To do a GET request the format on the URL should be:
http://<hostname>:8000/posts?fromUsername=<fromuser>&toUsername=<touser>&page=0&nMessages=<numberofmessages>
hostname should be postservice (I guess?)
fromuser should be the username of the sender
touser should be the username of the recipient
numberofmessages should be the desired number of messages to get

This is the format of the JSON that comes back from the request:
{
"id": "645ceefe5423974b37a6d061",
"fromUsername": "jonathan",
"toUsername": "martin",
"message": "This is a message",
"dateAndTime": "2023-05-11T13:34:54.105117379"
}
