CREATE TABLE public.order (
	order_no varchar NOT NULL,
	item_id int8 NULL,
	qty int4 NULL
)

CREATE TABLE public.item (
	id serial4 NOT NULL,
	"name" varchar NULL,
	price numeric NULL,
	CONSTRAINT item_pk PRIMARY KEY (id)
);
ALTER TABLE public.order ADD CONSTRAINT order_item_fk FOREIGN KEY (item_id) REFERENCES public.item(id);