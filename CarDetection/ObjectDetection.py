from ast import Index
from operator import contains
import cv2
import numpy as np
from PIL import Image
import glob


def function1(String, classId):
    net = cv2.dnn.readNet("yolov3.weights", "yolov3.cfg")
    with open("coco.names", "r") as f:
     classes = [line.strip() for line in f.readlines()]
    layer_names = net.getLayerNames()
    
    output_layers = [layer_names[i - 1] for i in net.getUnconnectedOutLayers()] #names of the objects
    colors = np.random.uniform(0, 255, size=(200, 3))
    for filename in glob.glob(String):
        im= Image.open(filename)

    img = np.array(im)
    img = cv2.resize(img, None, fx=0.4, fy=0.4)
    height, width, channels = img.shape

    blob = cv2.dnn.blobFromImage(img, 0.00392, (416, 416), (0, 0, 0), True, crop=False)
    net.setInput(blob)
    outs = net.forward(output_layers)

    # Showing informations on the screen
    class_ids = []
    confidences = []
    boxes = []
    for out in outs:
        for detection in out:
            scores = detection[5:]
            class_id = np.argmax(scores)
            confidence = scores[class_id]
            #Only for person, car or aeroplane 0 for person, 2 for car and 4 for aeroplane
            if confidence > 0.5 and (class_id == classId):
                # Object detected
                center_x = int(detection[0] * width)
                center_y = int(detection[1] * height)
                w = int(detection[2] * width)
                h = int(detection[3] * height)
                # Rectangle coordinates
                x = int(center_x - w / 2)
                y = int(center_y - h / 2)
                boxes.append([x, y, w, h])
                confidences.append(float(confidence))
                class_ids.append(class_id)
            

    indexes = cv2.dnn.NMSBoxes(boxes, confidences, 0.5, 0.4)
    font = cv2.FONT_HERSHEY_PLAIN
    for i in range(len(boxes)):
        if i in indexes:
            x, y, w, h = boxes[i]
            label = str(classes[classId])
            color = colors[i]
            cv2.rectangle(img, (x, y), (x + w, y + h), color, 1)
            cv2.putText(img, label + " " + str(confidences[i]), (x, y + 10), font, 1, color, 2)


    containsPerson = True
    if(classId == 0 and len(indexes) != 0):
        cv2.imwrite("C:\\Users\\stj.emaslan\\Desktop\\PersonDetected\\personDetected.jpg", img)
            
    if(classId == 2 and len(indexes) != 0):
        cv2.imwrite("C:\\Users\\stj.emaslan\\Desktop\\CarsDetected\\carDetected.jpg", img)

    if(classId == 4 and len(indexes) != 0):                   
        cv2.imwrite("C:\\Users\\stj.emaslan\\Desktop\\AeroplaneDetected\\aeroplaneDetected.jpg", img)
     
    return len(indexes)
    
    

#function1("C:\\Users\\stj.emaslan\\Desktop\\CarsDetected\\car.jpg", 4)
