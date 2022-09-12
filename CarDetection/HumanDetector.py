
from time import sleep
import ObjectDetection
from kafka import KafkaConsumer, KafkaProducer
consumer = KafkaConsumer('humanPath') 
producer = KafkaProducer(bootstrap_servers='localhost:9092')
for message in consumer:
    humans = ObjectDetection.function1(message.value, 0)
    future = producer.send('detHumanPath', b'%d' % humans)
    result = future.get(timeout=1)
