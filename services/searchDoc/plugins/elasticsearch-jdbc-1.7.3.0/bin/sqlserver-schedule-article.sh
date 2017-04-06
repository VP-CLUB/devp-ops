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
        "sql" : " SELECT a.is_share, a.Id as _id, a.Title, a.Appid, a.Category_id, a.Zhaiyao, a.Sell_price, a.Market_price, a.Cost_Price AS CostPrice, a.Seo_keywords, a.virtual_sell AS SellCount, a.img_url AS ImgUrl, a.update_time, a.rebates, a.jgid orgId, ISNULL(o.isws, 0) isws, c.title AS CategoryName, b.DisplayName BrandName, a.is_delete isDelete, a.status status, a.is_sys isSys, a.extType extType , a.extProductID extProductID, a.stock_quantity stock_quantity, STUFF( ( SELECT app_id FROM dbo.hk_goods_share share WHERE a.id = share.goods_id FOR XML PATH ('"'"''"'"') ), 1, 1, '"'"''"'"' ) shareAppid FROM dbo.hk_article AS a LEFT JOIN dbo.hk_article_category AS c ON a.category_id = c.id LEFT JOIN hk_jigou AS b ON a.JGID = b.id  LEFT JOIN dbo.hk_orgright o ON o.orgid = a.JGID WHERE 1 = 1 and a.is_delete=0 and a.status=0 and a.is_sys=1 and a.Type=1 ",
        "elasticsearch" : {                      
	 "cluster" : "vpclub-search-server",  
	 "host" : "localhost",  
	 "port" : 9300 
	},
	"index" : "myjdbc",
        "type" : "mytype",
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
