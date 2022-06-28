#-------------------------------------------------------------------------------
# Name:        module1
# Purpose:
#
# Author:      Fatou SECK
#
# Created:     17/06/2022
# Copyright:   (c) Fatou SECK 2022
# Licence:     <your licence>
#-------------------------------------------------------------------------------

from operator import itemgetter
from itertools import groupby
from tokenize import group
project=[]
ressource=[]
task=[]
progress=[]

class Project:
    def __init__(self,name,duration):
        project.append((name,duration))

    def add_resource(self,id,name):
        ressource.append((id,name))

    def add_task(self,id,load=0,resp="",descr=""):
        task.append((id,load,resp,descr))

    def set_date(self,date):
        date=date
        print("")

    def add_progress(self,task,rsc,work,comment):
        progress.append((task,rsc,work,comment))

    def total_progress(self):
        sortedList=sorted(progress,key=itemgetter(0))
        groups = groupby(sortedList, itemgetter(0))

        for (key, data) in groups:
            total=0
            for item in data:
                if key == item[0]:
                    total = total + item[2]
            print(key,", realized:",total)

    def print_summary(self):
        for i in project:
            print(i)
        for j in ressource:
            print(j)
        for k in task:
            print(k)
        for l in progress:
            print(l)
