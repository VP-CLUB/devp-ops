
/* 1. maxwell */
GRANT ALL on maxwell.* to 'maxwell'@'%' identified by 'maxwell';
GRANT SELECT, REPLICATION CLIENT, REPLICATION SLAVE on *.* to 'maxwell'@'%';


/* 2. 用户授权 给同步用户授权 */
GRANT ALL on otter.* to 'otter'@'%' identified by 'otter';
GRANT SELECT, REPLICATION CLIENT, REPLICATION SLAVE on *.* to 'otter'@'%';


/* 业务表授权，这里可以限定只授权同步业务的表 */
GRANT SELECT, INSERT, UPDATE, DELETE ON `moses_refund`.* TO `otter`@'%';
GRANT SELECT, INSERT, UPDATE, DELETE ON `mcs_message`.* TO `otter`@'%';
GRANT SELECT, INSERT, UPDATE, DELETE ON `moses_product`.* TO `otter`@'%';
GRANT SELECT, INSERT, UPDATE, DELETE ON `mcs_advert`.* TO `otter`@'%';
GRANT SELECT, INSERT, UPDATE, DELETE ON `mcs_order`.* TO `otter`@'%';
GRANT SELECT, INSERT, UPDATE, DELETE ON `moses_shop_admin`.* TO `otter`@'%';
GRANT SELECT, INSERT, UPDATE, DELETE ON `moses_zoneconf`.* TO `otter`@'%';
