PGDMP  	                    |            vetApp    16.2    16.2 ?    P           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            Q           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            R           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            S           1262    17719    vetApp    DATABASE     �   CREATE DATABASE "vetApp" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'English_United States.1252';
    DROP DATABASE "vetApp";
                postgres    false            �            1259    17721    animal    TABLE       CREATE TABLE public.animal (
    id bigint NOT NULL,
    breed character varying(255) NOT NULL,
    color character varying(255) NOT NULL,
    date_of_birth date NOT NULL,
    name character varying(255) NOT NULL,
    species character varying(255) NOT NULL,
    customer_id bigint
);
    DROP TABLE public.animal;
       public         heap    postgres    false            �            1259    17720    animal_id_seq    SEQUENCE     v   CREATE SEQUENCE public.animal_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.animal_id_seq;
       public          postgres    false    216            T           0    0    animal_id_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE public.animal_id_seq OWNED BY public.animal.id;
          public          postgres    false    215            �            1259    17730    appointment    TABLE     �   CREATE TABLE public.appointment (
    id bigint NOT NULL,
    appointment_date timestamp(6) without time zone,
    animal_id bigint,
    doctor_id bigint,
    appointment_end_date timestamp(6) without time zone
);
    DROP TABLE public.appointment;
       public         heap    postgres    false            �            1259    17729    appointment_id_seq    SEQUENCE     {   CREATE SEQUENCE public.appointment_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.appointment_id_seq;
       public          postgres    false    218            U           0    0    appointment_id_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public.appointment_id_seq OWNED BY public.appointment.id;
          public          postgres    false    217            �            1259    17737    available_date    TABLE     X   CREATE TABLE public.available_date (
    id bigint NOT NULL,
    available_date date
);
 "   DROP TABLE public.available_date;
       public         heap    postgres    false            �            1259    17890    available_date_doctors    TABLE     v   CREATE TABLE public.available_date_doctors (
    available_date_id bigint NOT NULL,
    doctors_id bigint NOT NULL
);
 *   DROP TABLE public.available_date_doctors;
       public         heap    postgres    false            �            1259    17736    available_date_id_seq    SEQUENCE     ~   CREATE SEQUENCE public.available_date_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.available_date_id_seq;
       public          postgres    false    220            V           0    0    available_date_id_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.available_date_id_seq OWNED BY public.available_date.id;
          public          postgres    false    219            �            1259    17903    available_dates_doctors    TABLE     v   CREATE TABLE public.available_dates_doctors (
    doctor_id bigint NOT NULL,
    available_date_id bigint NOT NULL
);
 +   DROP TABLE public.available_dates_doctors;
       public         heap    postgres    false            �            1259    17744    customer    TABLE       CREATE TABLE public.customer (
    id bigint NOT NULL,
    address character varying(255) NOT NULL,
    city character varying(255) NOT NULL,
    mail character varying(255) NOT NULL,
    name character varying(255) NOT NULL,
    phone character varying(255) NOT NULL
);
    DROP TABLE public.customer;
       public         heap    postgres    false            �            1259    17743    customer_id_seq    SEQUENCE     x   CREATE SEQUENCE public.customer_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.customer_id_seq;
       public          postgres    false    222            W           0    0    customer_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.customer_id_seq OWNED BY public.customer.id;
          public          postgres    false    221            �            1259    17753    doctor    TABLE       CREATE TABLE public.doctor (
    id bigint NOT NULL,
    address character varying(255) NOT NULL,
    city character varying(255) NOT NULL,
    mail character varying(255) NOT NULL,
    name character varying(255) NOT NULL,
    phone character varying(255) NOT NULL
);
    DROP TABLE public.doctor;
       public         heap    postgres    false            �            1259    17761    doctor_available_dates    TABLE     u   CREATE TABLE public.doctor_available_dates (
    doctor_id bigint NOT NULL,
    available_date_id bigint NOT NULL
);
 *   DROP TABLE public.doctor_available_dates;
       public         heap    postgres    false            �            1259    17752    doctor_id_seq    SEQUENCE     v   CREATE SEQUENCE public.doctor_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.doctor_id_seq;
       public          postgres    false    224            X           0    0    doctor_id_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE public.doctor_id_seq OWNED BY public.doctor.id;
          public          postgres    false    223            �            1259    17767    vaccine    TABLE     �   CREATE TABLE public.vaccine (
    id bigint NOT NULL,
    code character varying(255) NOT NULL,
    name character varying(255) NOT NULL,
    protection_finish_date date NOT NULL,
    protection_start_date date NOT NULL,
    animal_id bigint
);
    DROP TABLE public.vaccine;
       public         heap    postgres    false            �            1259    17766    vaccine_id_seq    SEQUENCE     w   CREATE SEQUENCE public.vaccine_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.vaccine_id_seq;
       public          postgres    false    227            Y           0    0    vaccine_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.vaccine_id_seq OWNED BY public.vaccine.id;
          public          postgres    false    226            �           2604    17724 	   animal id    DEFAULT     f   ALTER TABLE ONLY public.animal ALTER COLUMN id SET DEFAULT nextval('public.animal_id_seq'::regclass);
 8   ALTER TABLE public.animal ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    216    215    216            �           2604    17733    appointment id    DEFAULT     p   ALTER TABLE ONLY public.appointment ALTER COLUMN id SET DEFAULT nextval('public.appointment_id_seq'::regclass);
 =   ALTER TABLE public.appointment ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    218    217    218            �           2604    17740    available_date id    DEFAULT     v   ALTER TABLE ONLY public.available_date ALTER COLUMN id SET DEFAULT nextval('public.available_date_id_seq'::regclass);
 @   ALTER TABLE public.available_date ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    219    220    220            �           2604    17747    customer id    DEFAULT     j   ALTER TABLE ONLY public.customer ALTER COLUMN id SET DEFAULT nextval('public.customer_id_seq'::regclass);
 :   ALTER TABLE public.customer ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    221    222    222            �           2604    17756 	   doctor id    DEFAULT     f   ALTER TABLE ONLY public.doctor ALTER COLUMN id SET DEFAULT nextval('public.doctor_id_seq'::regclass);
 8   ALTER TABLE public.doctor ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    224    223    224            �           2604    17770 
   vaccine id    DEFAULT     h   ALTER TABLE ONLY public.vaccine ALTER COLUMN id SET DEFAULT nextval('public.vaccine_id_seq'::regclass);
 9   ALTER TABLE public.vaccine ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    227    226    227            @          0    17721    animal 
   TABLE DATA           ]   COPY public.animal (id, breed, color, date_of_birth, name, species, customer_id) FROM stdin;
    public          postgres    false    216   �J       B          0    17730    appointment 
   TABLE DATA           g   COPY public.appointment (id, appointment_date, animal_id, doctor_id, appointment_end_date) FROM stdin;
    public          postgres    false    218   [K       D          0    17737    available_date 
   TABLE DATA           <   COPY public.available_date (id, available_date) FROM stdin;
    public          postgres    false    220   �K       L          0    17890    available_date_doctors 
   TABLE DATA           O   COPY public.available_date_doctors (available_date_id, doctors_id) FROM stdin;
    public          postgres    false    228   L       M          0    17903    available_dates_doctors 
   TABLE DATA           O   COPY public.available_dates_doctors (doctor_id, available_date_id) FROM stdin;
    public          postgres    false    229   eL       F          0    17744    customer 
   TABLE DATA           H   COPY public.customer (id, address, city, mail, name, phone) FROM stdin;
    public          postgres    false    222   �L       H          0    17753    doctor 
   TABLE DATA           F   COPY public.doctor (id, address, city, mail, name, phone) FROM stdin;
    public          postgres    false    224   HM       I          0    17761    doctor_available_dates 
   TABLE DATA           N   COPY public.doctor_available_dates (doctor_id, available_date_id) FROM stdin;
    public          postgres    false    225   �M       K          0    17767    vaccine 
   TABLE DATA           k   COPY public.vaccine (id, code, name, protection_finish_date, protection_start_date, animal_id) FROM stdin;
    public          postgres    false    227   �M       Z           0    0    animal_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.animal_id_seq', 6, true);
          public          postgres    false    215            [           0    0    appointment_id_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.appointment_id_seq', 10, true);
          public          postgres    false    217            \           0    0    available_date_id_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.available_date_id_seq', 19, true);
          public          postgres    false    219            ]           0    0    customer_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.customer_id_seq', 5, true);
          public          postgres    false    221            ^           0    0    doctor_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.doctor_id_seq', 5, true);
          public          postgres    false    223            _           0    0    vaccine_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.vaccine_id_seq', 4, true);
          public          postgres    false    226            �           2606    17728    animal animal_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.animal
    ADD CONSTRAINT animal_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.animal DROP CONSTRAINT animal_pkey;
       public            postgres    false    216            �           2606    17735    appointment appointment_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.appointment
    ADD CONSTRAINT appointment_pkey PRIMARY KEY (id);
 F   ALTER TABLE ONLY public.appointment DROP CONSTRAINT appointment_pkey;
       public            postgres    false    218            �           2606    17742 "   available_date available_date_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public.available_date
    ADD CONSTRAINT available_date_pkey PRIMARY KEY (id);
 L   ALTER TABLE ONLY public.available_date DROP CONSTRAINT available_date_pkey;
       public            postgres    false    220            �           2606    17751    customer customer_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.customer
    ADD CONSTRAINT customer_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.customer DROP CONSTRAINT customer_pkey;
       public            postgres    false    222            �           2606    17765 2   doctor_available_dates doctor_available_dates_pkey 
   CONSTRAINT     �   ALTER TABLE ONLY public.doctor_available_dates
    ADD CONSTRAINT doctor_available_dates_pkey PRIMARY KEY (doctor_id, available_date_id);
 \   ALTER TABLE ONLY public.doctor_available_dates DROP CONSTRAINT doctor_available_dates_pkey;
       public            postgres    false    225    225            �           2606    17760    doctor doctor_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.doctor
    ADD CONSTRAINT doctor_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.doctor DROP CONSTRAINT doctor_pkey;
       public            postgres    false    224            �           2606    17774    vaccine vaccine_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.vaccine
    ADD CONSTRAINT vaccine_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.vaccine DROP CONSTRAINT vaccine_pkey;
       public            postgres    false    227            �           2606    17911 3   available_dates_doctors fk2bfx70y20wkrwgwbxs5cyejdy    FK CONSTRAINT     �   ALTER TABLE ONLY public.available_dates_doctors
    ADD CONSTRAINT fk2bfx70y20wkrwgwbxs5cyejdy FOREIGN KEY (doctor_id) REFERENCES public.doctor(id);
 ]   ALTER TABLE ONLY public.available_dates_doctors DROP CONSTRAINT fk2bfx70y20wkrwgwbxs5cyejdy;
       public          postgres    false    224    4769    229            �           2606    17780 '   appointment fk2kkeptdxfuextg5ch7xp3ytie    FK CONSTRAINT     �   ALTER TABLE ONLY public.appointment
    ADD CONSTRAINT fk2kkeptdxfuextg5ch7xp3ytie FOREIGN KEY (animal_id) REFERENCES public.animal(id);
 Q   ALTER TABLE ONLY public.appointment DROP CONSTRAINT fk2kkeptdxfuextg5ch7xp3ytie;
       public          postgres    false    218    216    4761            �           2606    17898 2   available_date_doctors fk6b0j7336p3lq2erw970sc2dhl    FK CONSTRAINT     �   ALTER TABLE ONLY public.available_date_doctors
    ADD CONSTRAINT fk6b0j7336p3lq2erw970sc2dhl FOREIGN KEY (available_date_id) REFERENCES public.available_date(id);
 \   ALTER TABLE ONLY public.available_date_doctors DROP CONSTRAINT fk6b0j7336p3lq2erw970sc2dhl;
       public          postgres    false    228    4765    220            �           2606    17775 "   animal fk6pvxm5gfjqxclb651be9unswe    FK CONSTRAINT     �   ALTER TABLE ONLY public.animal
    ADD CONSTRAINT fk6pvxm5gfjqxclb651be9unswe FOREIGN KEY (customer_id) REFERENCES public.customer(id);
 L   ALTER TABLE ONLY public.animal DROP CONSTRAINT fk6pvxm5gfjqxclb651be9unswe;
       public          postgres    false    216    4767    222            �           2606    17790 2   doctor_available_dates fkem4786lirf7gp27x13rgdf5gr    FK CONSTRAINT     �   ALTER TABLE ONLY public.doctor_available_dates
    ADD CONSTRAINT fkem4786lirf7gp27x13rgdf5gr FOREIGN KEY (available_date_id) REFERENCES public.available_date(id);
 \   ALTER TABLE ONLY public.doctor_available_dates DROP CONSTRAINT fkem4786lirf7gp27x13rgdf5gr;
       public          postgres    false    225    4765    220            �           2606    17893 2   available_date_doctors fker2bx8386ek0phctjd49b2bqm    FK CONSTRAINT     �   ALTER TABLE ONLY public.available_date_doctors
    ADD CONSTRAINT fker2bx8386ek0phctjd49b2bqm FOREIGN KEY (doctors_id) REFERENCES public.doctor(id);
 \   ALTER TABLE ONLY public.available_date_doctors DROP CONSTRAINT fker2bx8386ek0phctjd49b2bqm;
       public          postgres    false    228    224    4769            �           2606    17906 3   available_dates_doctors fkgn1eqi17ymj6q3j1d7r04lya8    FK CONSTRAINT     �   ALTER TABLE ONLY public.available_dates_doctors
    ADD CONSTRAINT fkgn1eqi17ymj6q3j1d7r04lya8 FOREIGN KEY (available_date_id) REFERENCES public.available_date(id);
 ]   ALTER TABLE ONLY public.available_dates_doctors DROP CONSTRAINT fkgn1eqi17ymj6q3j1d7r04lya8;
       public          postgres    false    229    4765    220            �           2606    17795 2   doctor_available_dates fkmwbox3wx1hrl0hhuxclpad372    FK CONSTRAINT     �   ALTER TABLE ONLY public.doctor_available_dates
    ADD CONSTRAINT fkmwbox3wx1hrl0hhuxclpad372 FOREIGN KEY (doctor_id) REFERENCES public.doctor(id);
 \   ALTER TABLE ONLY public.doctor_available_dates DROP CONSTRAINT fkmwbox3wx1hrl0hhuxclpad372;
       public          postgres    false    225    224    4769            �           2606    17800 #   vaccine fkne3kmh8y5pcyxwl4u2w9prw6j    FK CONSTRAINT     �   ALTER TABLE ONLY public.vaccine
    ADD CONSTRAINT fkne3kmh8y5pcyxwl4u2w9prw6j FOREIGN KEY (animal_id) REFERENCES public.animal(id);
 M   ALTER TABLE ONLY public.vaccine DROP CONSTRAINT fkne3kmh8y5pcyxwl4u2w9prw6j;
       public          postgres    false    216    4761    227            �           2606    17785 '   appointment fkoeb98n82eph1dx43v3y2bcmsl    FK CONSTRAINT     �   ALTER TABLE ONLY public.appointment
    ADD CONSTRAINT fkoeb98n82eph1dx43v3y2bcmsl FOREIGN KEY (doctor_id) REFERENCES public.doctor(id);
 Q   ALTER TABLE ONLY public.appointment DROP CONSTRAINT fkoeb98n82eph1dx43v3y2bcmsl;
       public          postgres    false    4769    224    218            @   �   x�3��(-ή�t�IL��4202�50�52��H�L�I-�t�O�4�2�*��,IEV|xOIN���`u&\��~�Ee�陉yx�:'�p�rr�$&%!�i�kh�k`��X��Vd�e�d ܍&�4����� �~<^      B   N   x�3�4202�50�5�P04�20 "NCN#q�8���%T�1�j#�jKQC����P�
s��9��<F��� ��!P      D   U   x�U̻� �:o�D���%���P��k�/!���&�$�P�B,��O�}B}#&L6�	��s�i��؋ZQO8�Fj�} |��,�      L   7   x���  �e#������!}�a��Jq�9-@vs).K0:�]_� �	b>      M   -   x�3�44�2�4bs � bC#.SNCca�e�ih",�b���� ��'      F   �   x�3��/*I�>����Ȇ�ļ��Β���Z�]�i`lj`lhd�e�靘rd#6թU陜� ������̄˄�p{jvn*6��9ɉ���`��Ȑ���Ԣl�J'edf�`j�e�yxNnQb^fe*��B��s���4� �=... l;U�      H   �   x�3��/*I�>����Ȇ�ļ��Β������X��&MLMML�L�L�jq�+-�H���PF��f�f\����E%�EX��V�gr���r.#l��C�`N��{J�2�RK�Z�LM,,̹b���� �Mk      I      x�3�4����� m       K   A   x�3�����N,�M�4202�50�521M�LC.cNo�(N�Ҕ�*�jL��1C�1�4����� R��     