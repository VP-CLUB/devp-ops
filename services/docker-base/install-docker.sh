cp  /etc/apt/sources.list  /etc/apt/sources.listbak
echo "deb http://mirrors.aliyun.com/ubuntu/ trusty main restricted universe multiverse
deb http://mirrors.aliyun.com/ubuntu/ trusty-security main restricted universe multiverse
deb http://mirrors.aliyun.com/ubuntu/ trusty-updates main restricted universe multiverse
deb http://mirrors.aliyun.com/ubuntu/ trusty-proposed main restricted universe multiverse
deb http://mirrors.aliyun.com/ubuntu/ trusty-backports main restricted universe multiverse
deb-src http://mirrors.aliyun.com/ubuntu/ trusty main restricted universe multiverse
deb-src http://mirrors.aliyun.com/ubuntu/ trusty-security main restricted universe multiverse
deb-src http://mirrors.aliyun.com/ubuntu/ trusty-updates main restricted universe multiverse
deb-src http://mirrors.aliyun.com/ubuntu/ trusty-proposed main restricted universe multiverse
deb-src http://mirrors.aliyun.com/ubuntu/ trusty-backports main restricted universe multiverse

deb http://mirrors.aliyuncs.com/ubuntu/ trusty main restricted universe multiverse
deb http://mirrors.aliyuncs.com/ubuntu/ trusty-security main restricted universe multiverse
deb http://mirrors.aliyuncs.com/ubuntu/ trusty-updates main restricted universe multiverse
deb http://mirrors.aliyuncs.com/ubuntu/ trusty-proposed main restricted universe multiverse
deb http://mirrors.aliyuncs.com/ubuntu/ trusty-backports main restricted universe multiverse
deb-src http://mirrors.aliyuncs.com/ubuntu/ trusty main restricted universe multiverse
deb-src http://mirrors.aliyuncs.com/ubuntu/ trusty-security main restricted universe multiverse
deb-src http://mirrors.aliyuncs.com/ubuntu/ trusty-updates main restricted universe multiverse
deb-src http://mirrors.aliyuncs.com/ubuntu/ trusty-proposed main restricted universe multiverse
deb-src http://mirrors.aliyuncs.com/ubuntu/ trusty-backports main restricted universe multiverse" >>/etc/apt/sources.list

sudo apt-get update

sudo apt-get install \
    linux-image-extra- \
    linux-image-extra-virtual

curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -

sudo apt-key fingerprint 0EBFCD88sudo add-

sudo add-apt-repository \
   "deb [arch=amd64] https://download.docker.com/linux/ubuntu \
   $(lsb_release -cs) \
   stable"

sudo apt-get update
sudo apt-get install docker-ce
