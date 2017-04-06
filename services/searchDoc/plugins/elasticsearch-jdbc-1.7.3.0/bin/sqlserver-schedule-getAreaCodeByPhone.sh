#!/bin/sh

DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
bin=${DIR}/../bin
lib=${DIR}/../lib

echo '
{
    "type" : "jdbc",
    "jdbc" : {
        "metrics" : {
            "lastexecutionstart" : "2015-05-10T10:58:00.038Z",
            "lastexecutionend" : "2017-05-10T10:58:00.044Z",
            "counter" : 1234
        },
	"schedule" : "0 0/2 * * * ?",
        "url" : "jdbc:sqlserver://172.16.45.1:1566;databaseName=vpclubcloud",
        "user" : "vpclubcloud",
        "password" : "vpclub#cloud^_123qKP#d",
        "sql" : " select t.id as _id,t.diqu,t.strat,t.[end],t.areaname,SUBSTRING(t.strat, 0, 8) as shortstart from hk_Numbersection t ",
        "index" : "getareacodebyphone",
        "type" : "getareacodebyphone",
        "index_settings" : {
            "index" : {
                "number_of_shards" : 1
            }
        }
    }
}
' | java \
    -cp "${lib}/*" \
    -Dlog4j.configurationFile=${bin}/log4j2.xml \
    org.xbib.tools.Runner \
    org.xbib.tools.JDBCImporter
