# 

## Model
www.msaez.io/#/188550980/storming/sc

## Before Running Services
### Make sure there is a Kafka server running
```
cd kafka
docker-compose up
```
- Check the Kafka messages:
```
cd infra
docker-compose exec -it kafka /bin/bash
cd /bin
./kafka-console-consumer --bootstrap-server localhost:9092 --topic
```

## Run the backend micro-services
See the README.md files inside the each microservices directory:

- branch
- center
- sanction
- host
- dashboard
- swift


## Run API Gateway (Spring Gateway)
```
cd gateway
mvn spring-boot:run
```

## Test by API
- branch
```
 http :8088/accepts id="id" customerId="customerId" customerName="customerName" tranType="tranType" documentImg="documentImg" acceptNo="acceptNo" status="status" branchNo="branchNo" 
 http :8088/ 
```
- center
```
 http :8088/reviews id="id" acceptNo="acceptNo" customerId="customerId" customerName="customerName" tranType="tranType" documentImg="documentImg" counterPartyId="counterPartyId" counterPartyName="counterPartyName" goodsName="goodsName" price="price" qty="qty" tradeDate="tradeDate" importCountry="importCountry" exportCountry="exportCountry" branchNo="branchNo" status="status" 
```
- sanction
```
 http :8088/sanctions id="id" acceptNo="acceptNo" status="status" importCountry="importCountry" exportCountry="exportCountry" counterPartyName="counterPartyName" customerId="customerId" customerName="customerName" counterPartyId="counterPartyId" 
```
- host
```
 http :8088/accounts id="id" acceptNo="acceptNo" status="status" customerId="customerId" customerName="customerName" tranType="tranType" counterPartyId="counterPartyId" counterPartyName="counterPartyName" goodsName="goodsName" price="price" qty="qty" importCountry="importCountry" exportCountry="exportCountry" branchNo="branchNo" 
 http :8088/ 
```
- dashboard
```
 http :8088/ 
 http :8088/ 
```
- swift
```
```


## Run the frontend
```
cd frontend
npm i
npm run serve
```

## Test by UI
Open a browser to localhost:8088

## Required Utilities

- httpie (alternative for curl / POSTMAN) and network utils
```
sudo apt-get update
sudo apt-get install net-tools
sudo apt install iputils-ping
pip install httpie
```

- kubernetes utilities (kubectl)
```
curl -LO "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl"
sudo install -o root -g root -m 0755 kubectl /usr/local/bin/kubectl
```

- aws cli (aws)
```
curl "https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip" -o "awscliv2.zip"
unzip awscliv2.zip
sudo ./aws/install
```

- eksctl 
```
curl --silent --location "https://github.com/weaveworks/eksctl/releases/latest/download/eksctl_$(uname -s)_amd64.tar.gz" | tar xz -C /tmp
sudo mv /tmp/eksctl /usr/local/bin
```

