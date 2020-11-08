-- public.items definition

-- Drop table

-- DROP TABLE public.items;

CREATE TABLE public.items (
	item_sys_id serial NOT NULL DEFAULT nextval('items_item_sys_id_seq'::regclass),
	item_name varchar NOT NULL,
	item_price numeric NOT NULL,
	item_in_stock bool NOT NULL DEFAULT false,
	item_quantity int4 NOT NULL DEFAULT 0
);