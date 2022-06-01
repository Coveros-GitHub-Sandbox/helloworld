import requests
import json
repos = int(input())
dict_a = dict()

for n in range(1,repos+1):
    
    resp = requests.get("https://api.github.com/orgs/netflix/repos?per_page=100&page="+str(n))
    responce_list = resp.json()
    
    for i in responce_list:          
        dict_a[i["full_name"]] = i["url"]

Sl_no = 0
for i in dict_a.items():
    Sl_no +=1
    msg = "{}: \t{} \t repo link is \t{}"
    print(msg.format(Sl_no,i[0],i[1]))
    file1 = open("myfile.xls","a")#append mode
    file1.write(msg.format(Sl_no,i[0],i[1])+"\n")
    file1.close()
