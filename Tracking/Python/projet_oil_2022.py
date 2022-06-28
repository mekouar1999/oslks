# -*- coding: utf-8 -*-
"""
Created on Tue Jun 14 16:59:08 2022

@author: cireg
"""

from Project_tracker import *
prj = Project(name="TheProject", duration=12)
# Project resources / team members
prj.add_resource(id='P1', name="FOFANA Siregbe")
prj.add_resource(id='P2', name="SECK fatou")
prj.add_resource(id='P3', name="KEITA nassou")
prj.add_resource(id='P4', name="DALAL yassine")
prj.add_resource(id='P5', name="MEKOUAR othman")
prj.add_resource(id='P6', name="KABA kanda")
ALL_TEAM = ('P1', 'P2', 'P3', 'P4', 'P5', 'P6')
NB_TEAM_MEMBERS = len(ALL_TEAM)
# Project tasks
prj.add_task(id='spé', descr="Specification des besoins")
prj.add_task(id='GitMvnTr1', load=NB_TEAM_MEMBERS * 0.8, descr="mise en place du doker ")
prj.add_task(id='MGT', load=NB_TEAM_MEMBERS * 0.4, descr="project management activities'")
prj.add_task(id='Conc', load=NB_TEAM_MEMBERS * 1.0, descr="conception")
prj.add_task(id='Dev', descr="developpement")
prj.add_task(id='Dev.doker', descr="introduction du doker compose")
prj.add_task(id='Dev.class', descr="Gestion des classes joueurs")
prj.add_task(id='Dev.joueur', descr="creation classe joueur")
prj.add_task(id='Dev.webservice', descr="developpement de l'anagrammeur")
prj.add_task(id='Rec', load=2, resp='P1', descr="recette")
prj.add_task(id='DOC', descr="Documentation")
prj.add_task(id='DOC.TRK', load=3, resp='P2', descr="Final tracking report")
prj.add_task(id='DOC.USR', descr="User documentation")

# Project tracking
prj.set_date("02/05/2022")
prj.add_progress(task='LRN.ING.CRS', rsc=ALL_TEAM, work=0.2, comment="")
prj.add_progress(task='LRN.TRK.CRS', rsc=ALL_TEAM, work=0.2, comment="First course on 'Project Tracking'")
prj.set_date("03/05/2022")
for r in ALL_TEAM:
    prj.add_progress(task='LRN.ING.CRS', rsc=r, work=0.2, comment="Second course on 'Outils pour Ing. Logicielle'")
prj.add_progress(task='MGT', rsc='P1', work=0.5, comment="Prepare team Github'")
# Print reports
prj.print_summary()