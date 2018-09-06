##crate a consul cluster on a single machine with docker
attention: this wiki not use the `-net=host` model, so do not use id in prod env.

1. this cluster contain 1 client agent and 3 server anget
2. no item 2

#### crete a network for consul cluster 
    
    sudo docker network create -d bridge --subnet=172.21.0.0/16 --gateway=172.21.0.1 consul

#### Fetcth the `consul` image

    docker pull consul

#### create server containers
1. run first server node
    
        sudo docker run -d --net=consul --name server0 --ip 172.21.1.1 \
         consul agent -server -bind=172.21.1.1 -bootstrap-expect=3;

2. run left two node

        sudo docker run -d --net=consul --name server1 --ip 172.21.1.2 \
         consul agent -server -bind=172.21.1.2 -retry-join=172.21.1.1 -bootstrap-expect=3;
         
        sudo docker run -d --net=consul --name server2 --ip 172.21.1.3 \
         consul agent -server -bind=172.21.1.3 -retry-join=172.21.1.1 -bootstrap-expect=3;

#### create client node
    
    sudo docker run -d --net=consul --name client0 --ip 172.21.2.1 -p 8500:8500 \
     consul agent -ui -bind=172.21.2.1 -retry-join=172.21.1.1 -client=0.0.0.0


#### finish
check the container status and log, it's ok ,right?
open your chrome and visit `http://172.21.2.1:8500/ui`, maybe it not the best network mode, but enough for dev,enjoy!
