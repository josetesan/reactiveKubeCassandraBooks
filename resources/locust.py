from locust import HttpLocust, TaskSet, task
import uuid, random, string

class WebsiteTasks(TaskSet):
    
    @task
    def createBooks(self):
        self.client.post("/book", {
          "title": ''.join(random.choice(string.ascii_uppercase + string.digits) for _ in range(10)),
          "author": ''.join(random.choice(string.ascii_uppercase + string.digits) for _ in range(10)),
          "language": "SPANISH",
          "id": str(uuid.uuid4()),
          "summary": ''.join(random.choice(string.ascii_uppercase + string.digits) for _ in range(128))   
    })
        

class WebsiteUser(HttpLocust):
    task_set = WebsiteTasks
    min_wait = 5000
    max_wait = 15000
