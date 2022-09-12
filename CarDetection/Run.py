import multiprocessing
import time
import CarDetector, HumanDetector, PlaneDetector

if __name__ == "__main__": 
    start_time = time.perf_counter()
    processes = []
    p = multiprocessing.Process(target=CarDetector.car())
    p1 = multiprocessing.Process(target=HumanDetector.human())
    p2 = multiprocessing.Process(target=PlaneDetector.plane())
    p.start()
    p1.start()
    p1.join()
    p2.start()
    p2.join()
