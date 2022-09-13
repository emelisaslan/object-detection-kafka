from time import sleep
import ObjectDetection
from kafka import KafkaConsumer, KafkaProducer
consumer = KafkaConsumer('planePath')
producer = KafkaProducer(bootstrap_servers='localhost:9092')

for message in consumer:
    planes = ObjectDetection.function1(message.value, 4)
    print("plane start")
    future = producer.send('detPlanePath', b'%d' % planes)
    result = future.get(timeout=1)
    print("plane finish")



