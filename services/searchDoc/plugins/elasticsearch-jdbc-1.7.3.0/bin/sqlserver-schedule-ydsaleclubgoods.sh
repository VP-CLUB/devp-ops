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
        "sql" : [{"statement":"SELECT a.id as _id,ISNULL(( STUFF( ( SELECT sku.color_title + '"'"'!!'"'"' + sku.unit_title + '"'"'!!'"'"' + CAST (sku.price AS VARCHAR(15)) + '"'"',,'"'"' FROM dbo.hk_SKU sku WHERE sku.goods_id = A.id FOR XML PATH ('"'"''"'"') ), 1, 0, '"'"''"'"') ), '"'"''"'"' ) color , a.id AS 'ProductID', a.title AS 'productName', A.SellCount sellCount, A.virtual_sell virtualSell, A.sell_price sellPrice, A.img_url AS productImage, ST.id AS StoreId, J.BrandLogo StoreImage, J.DisplayName AS StoreName, J.id jgId, j.lat lat, j.lng lng, CAST (j.lat AS VARCHAR(15)) +'"'"','"'"'+ CAST (j.lng AS VARCHAR(15)) as location ,j.DisplayName orgname, j.Phone cusServicePhone, j.CityName + j.AreaName + j.Address StoreAddress, j.AreaName AS 'town', j.CityName, A.is_hot AS 'productType', A.is_delete AS 'isDelete', A.status, A.is_sys AS 'isSys', A.brand_id AS 'brandId', ISNULL( ISNULL(br.aliasname, br.brandname), '"'"''"'"' ) AS 'brandName', ISNULL(hm.model_name, '"'"'null'"'"') AS 'modelName', a.appid, tpe.area_code, tpe.model AS 'isCmcc', area.diqucode AS 'dxtAreaCode', area.diquname AS 'dxtCityName', a.type,a.SellCount, cg.id categoryId, cg.content AS categoryName, ap.activities_id activitId FROM hk_article a INNER JOIN hk_jigou j ON a.JGID = j.id AND j.lat > 0 AND j.lng > 0 AND j.appid = 100000015 INNER JOIN hk_Stores AS ST ON ST.jgid = J.id AND ST.appid = A.appid AND ( ST.isofficial = 2 OR ST.isofficial = 1 ) LEFT JOIN hk_brand br ON a.brand_id = br.id AND br.appid = 100000015 LEFT JOIN dbo.hk_article_model_map hmm ON hmm.article_id = A.id LEFT JOIN dbo.hk_article_model hm ON hm.id = hmm.model_id LEFT JOIN dbo.tco_product_ext tpe ON tpe.product_id = A.id AND tpe.appid = 100000015 LEFT JOIN tco_phonearea_map AS area ON J.CityCode = area.citycode LEFT JOIN dbo.hk_article_category cg ON cg.id = a.category_id LEFT JOIN hk_activities_products ap ON ap.product_id = A.id WHERE 1 =1 AND EXISTS ( SELECT ProductID FROM hk_product_store_map WHERE ProductID = a.id AND status = 1 AND appid = 100000015) AND A.Type = 1 AND a.is_delete=0 AND a.status=0 AND a.is_sys=1 ",
		   "parameter":[
		             
		   ],
		   callable:true
	        }],
	"ignore_null_values" : true,
        "index" : "ydsaleclubgoods",
        "type" : "ydsaleclubgoods",
        "index_settings" : {
            "index" : {
                "number_of_shards" : 5
            }
        }
    }
}
' | java \
    -cp "${lib}/*" \
    -Dlog4j.configurationFile=${bin}/log4j2.xml \
    org.xbib.tools.Runner \
    org.xbib.tools.JDBCImporter
