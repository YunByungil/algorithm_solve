-- 코드를 입력하세요
SELECT warehouse_id, warehouse_name, address, IFNULL(freezer_yn, 'N') as freezer_yn
from food_warehouse
where address like '경기도%'
order by warehouse_id asc
