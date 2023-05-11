Application is running on port 8000<BR>
Together with a mongodb instance<BR>
<BR>
To run in docker containers  via a network called mynetwork:<BR>
docker network create mynetwork<BR>
docker run -p 27017:27017 --name mymongo --network-alias mymongo --network mynetwork -d mongo:latest<BR>
docker run -d --name postservice --network-alias postservice --network mynetwork -p 8000:8000 postservice:latest<BR>
<BR>
Docker image is available on <BR>
https://hub.docker.com/r/jonathanjonathan001/postservice <BR>
docker pull jonathanjonathan001/postservice:latest
<BR>
<BR>
URL is /posts for POST and GET<BR>
JSON format for POST:<BR>
{<BR>
"fromUsername": "kalle",<BR>
"toUsername": "martin",<BR>
"message": "This is a message"<BR>
}<BR>
<BR>
To do a GET request the format on the URL should be:<BR>
http://hostname:8000/posts?fromUsername=fromuser&toUsername=touser&page=0&nMessages=numberofmessages <BR>
hostname should be postservice (I guess?)<BR>
fromuser should be the username of the sender<BR>
touser should be the username of the recipient<BR>
numberofmessages should be the desired number of messages to get<BR>
<BR>
This is the format of the JSON that comes back from the request:<BR>
{<BR>
"id": "645ceefe5423974b37a6d061",<BR>
"fromUsername": "jonathan",<BR>
"toUsername": "martin",<BR>
"message": "This is a message",<BR>
"dateAndTime": "2023-05-11T13:34:54.105117379"<BR>
}<BR>
