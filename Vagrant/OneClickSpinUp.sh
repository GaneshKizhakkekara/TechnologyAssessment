#!/bin/bash

git_url=https://github.com/GaneshKizhakkekara/TechnologyAssessment.git
clone_path=/root/GaneshHPSE
sourcefile_path=/root/GaneshHPSE/Technology_Assessment/Vagrant


echo "Bringing down all the existing running Vagrant services of Shortest Path"

vagrant destroy database -f 

sleep 2

vagrant destroy appvm -f 

sleep 2

vagrant destroy haproxy -f 

sleep 2

#Ensure to clear the existing files from the Clone Path
echo "Clear the existing files from the Technology_Assessment"
sleep 2

echo "Path in which the Master Branch will be Cloned is $clone_path"
rm -rf $clone_path

#Create a directory to which the Branch has to be cloned from GIT
echo "Make Directory for Clone"

mkdir -p $clone_path

sleep 2

#Clone the GIT Repo to your Clone Path
echo "Started git Clone with Technology_Assessment"

cd $clone_path
sleep 2
git clone $git_url

sleep 5

#Providing full permissions fir the Clone directory
echo "Giving full permissions to Clone Directory"

chmod -R 777 $clone_path


#Navigate to the source folder to copy the files to desired file path
cd $sourcefile_path

cp Vagrantfile $clone_path

sleep 2

cp *.sh $clone_path

sleep 2

cp *.cfg $clone_path

sleep 2

cp *.conf $clone_path

echo "Copied all source file for Vagrant Spin Up - Here we go !!!!!!!!!!"
cd $clone_path

sleep 5

echo "Bringing Up ShortestPath Vagrant Setup in one Click !!"

vagrant up

exit
