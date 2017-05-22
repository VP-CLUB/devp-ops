oc new-project moses-dev
oc new-project moses-stage
oc new-project zookeeper-cluster
oc new-project hazelcast-cluster



oadm policy add-role-to-user admin huangjun -n zookeeper-cluster
oadm policy add-role-to-user admin chenwei -n moses-dev
oadm policy add-role-to-user admin zhangbin -n moses-dev
oadm policy add-role-to-user admin zhonghang -n moses-dev
oadm policy add-role-to-user admin litao -n moses-dev
oadm policy add-role-to-user admin songdengwei -n moses-dev

oadm policy add-role-to-user admin wanjiawei -n mcs-dev
oadm policy add-role-to-user admin wangxiaohu -n mcs-dev

oadm policy add-role-to-user admin chenwei hazelcast-cluster
oadm policy add-role-to-user admin zhangbin hazelcast-cluster
oadm policy add-role-to-user admin zhonghang hazelcast-cluster
oadm policy add-role-to-user admin huangjun hazelcast-cluster
oadm policy add-role-to-user admin wanjiawei hazelcast-cluster
oadm policy add-role-to-user admin wangxiaohu -n moses-stage

oadm policy add-role-to-user admin fangbo -n kafka


#新项目授权cicd权限
oc policy add-role-to-user edit system:serviceaccount:cicd:jenkins -n your-project

oc policy add-role-to-user edit system:serviceaccount:cicd:default -n your-project