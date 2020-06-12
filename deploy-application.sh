echo "Acessando pasta para startar Consul e MongoDB"
cd docker-depends-on-application/
docker-compose up -d
sleep 10
echo "Criando KV para efetuar conexão com o mongo"
curl -XPUT -H "Content-type: application/json" -d '{"mongo" : {"uri" : "mongodb://root:123Mudar@192.168.0.3:27017/admin"}}' 'http://192.168.0.3:8500/v1/kv/config/application/data'
echo "Voltando para raiz do projeto para efetuar build"
cd ..
echo "Buildando JAR"
mvn clean install package -DskipTests
echo "Criando e startando imagem do projeto"
docker-compose up -d