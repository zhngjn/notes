
# run an image
docker run <image:tag> command args...

# interactive
docker run -i -t ubuntu:15.10 /bin/bash
exit

# daemon
docker run -d ubuntu:15.10 /bin/sh -c "while true; do echo hello world; sleep 1; done"

docker ps -a

# logs in container
docker logs -f <container id>

# stop/start
docker stop <container id>
docker start <container id>
docker restart <container id>

# help
docker
docker <cmd> --help

#
--name <name>

# go into docker
docker attach <container id>
docker exec -it <container id> /bin/bash

# export/import
docker export <container id> snapshot.tar
cat snapshot.tar | docker import - <image>

docker import <url>

# remove
docker rm -f <container id>
# clean the stopped containers
docker container prune 


docker pull <web app>
# -P mapping container port to host
docker run -d -P <web app> python app.py
# assign port (-p container:host)
-p 5000:5000

# ps in container
docker top <container id>

# container information
docker inspect <container id>

# last created container
docker ps -l

docker守护进程启动的时候，会默认赋予名字为docker的用户组读写Unix socket的权限，因此只要创建docker用户组，并将当前用户加入到docker用户组中，那么当前用户就有权限访问Unix socket了，进而也就可以执行docker相关命令
sudo groupadd docker     #添加docker用户组
sudo gpasswd -a $USER docker     #将登陆用户加入到docker用户组中
newgrp docker     #更新用户组
docker ps    #测试docker命令是否可以使用sudo正常使用

# images
docker images
docker pull <image:tag>

# search image
[Docker Hub](https://hub.docker.com/)
docker search <image>

# delete image
docker rmi <image>

# update image
1. go to container
    docker run -t -i ubuntu:15.10 /bin/bash
2. update
    apt-get update
3. exit
    exit
4. commit new image
    docker commit -m="message" -a="author" <container id> <image:tag>

# create a new image
1. create Dockerfile
    FROM    centos:6.7
    MAINTAINER      Fisher "fisher@sudops.com"

    RUN     /bin/echo 'root:123456' |chpasswd
    RUN     useradd runoob
    EXPOSE  22
    EXPOSE  80
    CMD     /usr/sbin/sshd -D
    
2. build
    docker build -t runoob/centos:6.7 <Dockerfile path>

# add a tag
docker tag <image id> <image:new tag>


