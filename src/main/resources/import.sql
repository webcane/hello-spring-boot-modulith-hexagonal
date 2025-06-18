-- orders
insert into order_entity(id, location, status) values ('757d9c0f-400f-4137-9aea-83e64ba3efb2', 1, 1);
insert into line_item_entity(id, order_id, drink, size, milk, quantity) values ('01ddf82a-5bed-4b56-b7e4-69e76b29f1bc', '757d9c0f-400f-4137-9aea-83e64ba3efb2', 1, 1, 1, 1);
-- payments
insert into payment_entity(id, order_id, card_holder_name, card_number, expiry_month, expiry_year, paid) values ('10fd6267-ea74-4c29-be97-7fc5c81241a5', '757d9c0f-400f-4137-9aea-83e64ba3efb2', 'Michael Faraday', '11223344', 0, 2023, current_timestamp);
