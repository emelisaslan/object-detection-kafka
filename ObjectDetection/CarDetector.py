from asyncio.windows_events import NULL
from multiprocessing.connection import wait
import time
from time import sleep
import ObjectDetection
from kafka import KafkaConsumer, KafkaProducer
from healtService import heartBeatSender
consumer = KafkaConsumer('carPath')
producer = KafkaProducer(bootstrap_servers='localhost:9092')
for message in consumer:
    cars = ObjectDetection.function1(message.value, 2)
    future = producer.send('detCarPath', b'%d' % cars)
    result = future.get(timeout=1)







