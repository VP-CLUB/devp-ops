#create and grant daemonset role
oc apply -f role.yaml　

oc apply -f router.yaml -n ip-router
#oadm policy add-role-to-user daemonset-admin chenwei


