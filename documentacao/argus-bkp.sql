PGDMP         1            
    w            argus    10.10    10.10 n    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false            �           1262    22440    argus    DATABASE     �   CREATE DATABASE argus WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Portuguese_Brazil.1252' LC_CTYPE = 'Portuguese_Brazil.1252';
    DROP DATABASE argus;
          
   gadohumano    false                        2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
             postgres    false            �           0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                  postgres    false    3                        3079    12924    plpgsql 	   EXTENSION     ?   CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;
    DROP EXTENSION plpgsql;
                  false            �           0    0    EXTENSION plpgsql    COMMENT     @   COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';
                       false    1            �            1259    24261    alunos    TABLE     �   CREATE TABLE public.alunos (
    id bigint NOT NULL,
    mae_id bigint NOT NULL,
    pai_id bigint NOT NULL,
    pessoa_id bigint NOT NULL,
    responsavel_pessoa_id bigint NOT NULL,
    turma_id bigint
);
    DROP TABLE public.alunos;
       public      
   gadohumano    false    3            �            1259    24259    alunos_id_seq    SEQUENCE     v   CREATE SEQUENCE public.alunos_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.alunos_id_seq;
       public    
   gadohumano    false    3    198            �           0    0    alunos_id_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE public.alunos_id_seq OWNED BY public.alunos.id;
            public    
   gadohumano    false    197            �            1259    24269    aten_ped    TABLE       CREATE TABLE public.aten_ped (
    id bigint NOT NULL,
    data_atendimento timestamp without time zone NOT NULL,
    data_realizado timestamp without time zone,
    det_atendimento character varying(255) NOT NULL,
    situcao character varying(255) NOT NULL
);
    DROP TABLE public.aten_ped;
       public      
   gadohumano    false    3            �            1259    24267    aten_ped_id_seq    SEQUENCE     x   CREATE SEQUENCE public.aten_ped_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.aten_ped_id_seq;
       public    
   gadohumano    false    200    3            �           0    0    aten_ped_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.aten_ped_id_seq OWNED BY public.aten_ped.id;
            public    
   gadohumano    false    199            �            1259    24280    contatos    TABLE     �   CREATE TABLE public.contatos (
    id bigint NOT NULL,
    celular character varying(15),
    telefone character varying(15)
);
    DROP TABLE public.contatos;
       public      
   gadohumano    false    3            �            1259    24278    contatos_id_seq    SEQUENCE     x   CREATE SEQUENCE public.contatos_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.contatos_id_seq;
       public    
   gadohumano    false    3    202            �           0    0    contatos_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.contatos_id_seq OWNED BY public.contatos.id;
            public    
   gadohumano    false    201            �            1259    24288 
   curriculos    TABLE     �   CREATE TABLE public.curriculos (
    id bigint NOT NULL,
    ano_letivo character varying(10) NOT NULL,
    codigo character varying(10) NOT NULL,
    nome character varying(30) NOT NULL
);
    DROP TABLE public.curriculos;
       public      
   gadohumano    false    3            �            1259    24286    curriculos_id_seq    SEQUENCE     z   CREATE SEQUENCE public.curriculos_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.curriculos_id_seq;
       public    
   gadohumano    false    204    3            �           0    0    curriculos_id_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE public.curriculos_id_seq OWNED BY public.curriculos.id;
            public    
   gadohumano    false    203            �            1259    23221    curriculos_turmas    TABLE     k   CREATE TABLE public.curriculos_turmas (
    curriculo_id bigint NOT NULL,
    turmas_id bigint NOT NULL
);
 %   DROP TABLE public.curriculos_turmas;
       public      
   gadohumano    false    3            �            1259    24294    disciplina_curriculo    TABLE     r   CREATE TABLE public.disciplina_curriculo (
    disciplina_id bigint NOT NULL,
    curriculo_id bigint NOT NULL
);
 (   DROP TABLE public.disciplina_curriculo;
       public      
   gadohumano    false    3            �            1259    24299    disciplinas    TABLE     �   CREATE TABLE public.disciplinas (
    id bigint NOT NULL,
    carga_horaria integer NOT NULL,
    codigo character varying(8) NOT NULL,
    nome character varying(20) NOT NULL
);
    DROP TABLE public.disciplinas;
       public      
   gadohumano    false    3            �            1259    24297    disciplinas_id_seq    SEQUENCE     {   CREATE SEQUENCE public.disciplinas_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.disciplinas_id_seq;
       public    
   gadohumano    false    207    3            �           0    0    disciplinas_id_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public.disciplinas_id_seq OWNED BY public.disciplinas.id;
            public    
   gadohumano    false    206            �            1259    24307 	   enderecos    TABLE     K  CREATE TABLE public.enderecos (
    id bigint NOT NULL,
    bairro character varying(30) NOT NULL,
    cep character varying(10) NOT NULL,
    cidade character varying(30) NOT NULL,
    complemento character varying(50),
    numero integer NOT NULL,
    rua character varying(100) NOT NULL,
    uf character varying(2) NOT NULL
);
    DROP TABLE public.enderecos;
       public      
   gadohumano    false    3            �            1259    24305    enderecos_id_seq    SEQUENCE     y   CREATE SEQUENCE public.enderecos_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.enderecos_id_seq;
       public    
   gadohumano    false    209    3            �           0    0    enderecos_id_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.enderecos_id_seq OWNED BY public.enderecos.id;
            public    
   gadohumano    false    208            �            1259    24315    funcionarios    TABLE     �   CREATE TABLE public.funcionarios (
    id bigint NOT NULL,
    carga_horaria integer NOT NULL,
    cpf character varying(14) NOT NULL,
    pessoa_id bigint NOT NULL,
    usuario_id bigint NOT NULL
);
     DROP TABLE public.funcionarios;
       public      
   gadohumano    false    3            �            1259    24313    funcionarios_id_seq    SEQUENCE     |   CREATE SEQUENCE public.funcionarios_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public.funcionarios_id_seq;
       public    
   gadohumano    false    3    211            �           0    0    funcionarios_id_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public.funcionarios_id_seq OWNED BY public.funcionarios.id;
            public    
   gadohumano    false    210            �            1259    24323 
   matriculas    TABLE     �  CREATE TABLE public.matriculas (
    id bigint NOT NULL,
    matricula character varying(25),
    media_final numeric(2,2) NOT NULL,
    media_geral numeric(2,2) NOT NULL,
    nota_1 numeric(2,2) NOT NULL,
    nota_2 numeric(2,2) NOT NULL,
    nota_3 numeric(2,2) NOT NULL,
    nota_4 numeric(2,2) NOT NULL,
    prova_final numeric(2,2) NOT NULL,
    situacao character varying(20) NOT NULL,
    aluno_id bigint,
    disciplina_id bigint,
    professor_id bigint,
    turma_id bigint
);
    DROP TABLE public.matriculas;
       public      
   gadohumano    false    3            �            1259    24321    matriculas_id_seq    SEQUENCE     z   CREATE SEQUENCE public.matriculas_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.matriculas_id_seq;
       public    
   gadohumano    false    3    213            �           0    0    matriculas_id_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE public.matriculas_id_seq OWNED BY public.matriculas.id;
            public    
   gadohumano    false    212            �            1259    24331    pessoas    TABLE     0  CREATE TABLE public.pessoas (
    id bigint NOT NULL,
    ativo boolean NOT NULL,
    data_nascimento timestamp without time zone NOT NULL,
    naturalidade character varying(3) NOT NULL,
    nome character varying(100) NOT NULL,
    rg character varying(22) NOT NULL,
    endereco_id bigint NOT NULL
);
    DROP TABLE public.pessoas;
       public      
   gadohumano    false    3            �            1259    24329    pessoas_id_seq    SEQUENCE     w   CREATE SEQUENCE public.pessoas_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.pessoas_id_seq;
       public    
   gadohumano    false    215    3            �           0    0    pessoas_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.pessoas_id_seq OWNED BY public.pessoas.id;
            public    
   gadohumano    false    214            �            1259    24337    res_fin    TABLE     g   CREATE TABLE public.res_fin (
    cpf character varying(14) NOT NULL,
    pessoa_id bigint NOT NULL
);
    DROP TABLE public.res_fin;
       public      
   gadohumano    false    3            �            1259    24344    turmas    TABLE     �   CREATE TABLE public.turmas (
    id bigint NOT NULL,
    ano_escolar character varying(10) NOT NULL,
    descricao character varying(255),
    turno character varying(10),
    curriculo_id bigint NOT NULL
);
    DROP TABLE public.turmas;
       public      
   gadohumano    false    3            �            1259    24342    turmas_id_seq    SEQUENCE     v   CREATE SEQUENCE public.turmas_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.turmas_id_seq;
       public    
   gadohumano    false    3    218            �           0    0    turmas_id_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE public.turmas_id_seq OWNED BY public.turmas.id;
            public    
   gadohumano    false    217            �            1259    24352    usuarios    TABLE     �   CREATE TABLE public.usuarios (
    id bigint NOT NULL,
    ativo boolean NOT NULL,
    email character varying(50) NOT NULL,
    login character varying(50) NOT NULL,
    senha character varying(50) NOT NULL,
    tipo character varying(255) NOT NULL
);
    DROP TABLE public.usuarios;
       public      
   gadohumano    false    3            �            1259    24350    usuarios_id_seq    SEQUENCE     x   CREATE SEQUENCE public.usuarios_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.usuarios_id_seq;
       public    
   gadohumano    false    220    3            �           0    0    usuarios_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.usuarios_id_seq OWNED BY public.usuarios.id;
            public    
   gadohumano    false    219            �
           2604    24264 	   alunos id    DEFAULT     f   ALTER TABLE ONLY public.alunos ALTER COLUMN id SET DEFAULT nextval('public.alunos_id_seq'::regclass);
 8   ALTER TABLE public.alunos ALTER COLUMN id DROP DEFAULT;
       public    
   gadohumano    false    198    197    198            �
           2604    24272    aten_ped id    DEFAULT     j   ALTER TABLE ONLY public.aten_ped ALTER COLUMN id SET DEFAULT nextval('public.aten_ped_id_seq'::regclass);
 :   ALTER TABLE public.aten_ped ALTER COLUMN id DROP DEFAULT;
       public    
   gadohumano    false    200    199    200            �
           2604    24283    contatos id    DEFAULT     j   ALTER TABLE ONLY public.contatos ALTER COLUMN id SET DEFAULT nextval('public.contatos_id_seq'::regclass);
 :   ALTER TABLE public.contatos ALTER COLUMN id DROP DEFAULT;
       public    
   gadohumano    false    201    202    202            �
           2604    24291    curriculos id    DEFAULT     n   ALTER TABLE ONLY public.curriculos ALTER COLUMN id SET DEFAULT nextval('public.curriculos_id_seq'::regclass);
 <   ALTER TABLE public.curriculos ALTER COLUMN id DROP DEFAULT;
       public    
   gadohumano    false    204    203    204            �
           2604    24302    disciplinas id    DEFAULT     p   ALTER TABLE ONLY public.disciplinas ALTER COLUMN id SET DEFAULT nextval('public.disciplinas_id_seq'::regclass);
 =   ALTER TABLE public.disciplinas ALTER COLUMN id DROP DEFAULT;
       public    
   gadohumano    false    207    206    207            �
           2604    24310    enderecos id    DEFAULT     l   ALTER TABLE ONLY public.enderecos ALTER COLUMN id SET DEFAULT nextval('public.enderecos_id_seq'::regclass);
 ;   ALTER TABLE public.enderecos ALTER COLUMN id DROP DEFAULT;
       public    
   gadohumano    false    209    208    209            �
           2604    24318    funcionarios id    DEFAULT     r   ALTER TABLE ONLY public.funcionarios ALTER COLUMN id SET DEFAULT nextval('public.funcionarios_id_seq'::regclass);
 >   ALTER TABLE public.funcionarios ALTER COLUMN id DROP DEFAULT;
       public    
   gadohumano    false    211    210    211            �
           2604    24326    matriculas id    DEFAULT     n   ALTER TABLE ONLY public.matriculas ALTER COLUMN id SET DEFAULT nextval('public.matriculas_id_seq'::regclass);
 <   ALTER TABLE public.matriculas ALTER COLUMN id DROP DEFAULT;
       public    
   gadohumano    false    212    213    213            �
           2604    24334 
   pessoas id    DEFAULT     h   ALTER TABLE ONLY public.pessoas ALTER COLUMN id SET DEFAULT nextval('public.pessoas_id_seq'::regclass);
 9   ALTER TABLE public.pessoas ALTER COLUMN id DROP DEFAULT;
       public    
   gadohumano    false    214    215    215            �
           2604    24347 	   turmas id    DEFAULT     f   ALTER TABLE ONLY public.turmas ALTER COLUMN id SET DEFAULT nextval('public.turmas_id_seq'::regclass);
 8   ALTER TABLE public.turmas ALTER COLUMN id DROP DEFAULT;
       public    
   gadohumano    false    218    217    218            �
           2604    24355    usuarios id    DEFAULT     j   ALTER TABLE ONLY public.usuarios ALTER COLUMN id SET DEFAULT nextval('public.usuarios_id_seq'::regclass);
 :   ALTER TABLE public.usuarios ALTER COLUMN id DROP DEFAULT;
       public    
   gadohumano    false    220    219    220            i          0    24261    alunos 
   TABLE DATA               `   COPY public.alunos (id, mae_id, pai_id, pessoa_id, responsavel_pessoa_id, turma_id) FROM stdin;
    public    
   gadohumano    false    198   ?       k          0    24269    aten_ped 
   TABLE DATA               b   COPY public.aten_ped (id, data_atendimento, data_realizado, det_atendimento, situcao) FROM stdin;
    public    
   gadohumano    false    200   �       m          0    24280    contatos 
   TABLE DATA               9   COPY public.contatos (id, celular, telefone) FROM stdin;
    public    
   gadohumano    false    202   �       o          0    24288 
   curriculos 
   TABLE DATA               B   COPY public.curriculos (id, ano_letivo, codigo, nome) FROM stdin;
    public    
   gadohumano    false    204   �       g          0    23221    curriculos_turmas 
   TABLE DATA               D   COPY public.curriculos_turmas (curriculo_id, turmas_id) FROM stdin;
    public    
   gadohumano    false    196   >�       p          0    24294    disciplina_curriculo 
   TABLE DATA               K   COPY public.disciplina_curriculo (disciplina_id, curriculo_id) FROM stdin;
    public    
   gadohumano    false    205   [�       r          0    24299    disciplinas 
   TABLE DATA               F   COPY public.disciplinas (id, carga_horaria, codigo, nome) FROM stdin;
    public    
   gadohumano    false    207   �       t          0    24307 	   enderecos 
   TABLE DATA               Z   COPY public.enderecos (id, bairro, cep, cidade, complemento, numero, rua, uf) FROM stdin;
    public    
   gadohumano    false    209   �       v          0    24315    funcionarios 
   TABLE DATA               U   COPY public.funcionarios (id, carga_horaria, cpf, pessoa_id, usuario_id) FROM stdin;
    public    
   gadohumano    false    211   �       x          0    24323 
   matriculas 
   TABLE DATA               �   COPY public.matriculas (id, matricula, media_final, media_geral, nota_1, nota_2, nota_3, nota_4, prova_final, situacao, aluno_id, disciplina_id, professor_id, turma_id) FROM stdin;
    public    
   gadohumano    false    213   _�       z          0    24331    pessoas 
   TABLE DATA               b   COPY public.pessoas (id, ativo, data_nascimento, naturalidade, nome, rg, endereco_id) FROM stdin;
    public    
   gadohumano    false    215   ��       {          0    24337    res_fin 
   TABLE DATA               1   COPY public.res_fin (cpf, pessoa_id) FROM stdin;
    public    
   gadohumano    false    216   L�       }          0    24344    turmas 
   TABLE DATA               Q   COPY public.turmas (id, ano_escolar, descricao, turno, curriculo_id) FROM stdin;
    public    
   gadohumano    false    218   ��                 0    24352    usuarios 
   TABLE DATA               H   COPY public.usuarios (id, ativo, email, login, senha, tipo) FROM stdin;
    public    
   gadohumano    false    220   I�       �           0    0    alunos_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.alunos_id_seq', 3, true);
            public    
   gadohumano    false    197            �           0    0    aten_ped_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.aten_ped_id_seq', 1, false);
            public    
   gadohumano    false    199            �           0    0    contatos_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.contatos_id_seq', 1, false);
            public    
   gadohumano    false    201            �           0    0    curriculos_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.curriculos_id_seq', 5, true);
            public    
   gadohumano    false    203            �           0    0    disciplinas_id_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.disciplinas_id_seq', 18, true);
            public    
   gadohumano    false    206            �           0    0    enderecos_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.enderecos_id_seq', 21, true);
            public    
   gadohumano    false    208            �           0    0    funcionarios_id_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.funcionarios_id_seq', 4, true);
            public    
   gadohumano    false    210            �           0    0    matriculas_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.matriculas_id_seq', 3, true);
            public    
   gadohumano    false    212            �           0    0    pessoas_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.pessoas_id_seq', 21, true);
            public    
   gadohumano    false    214            �           0    0    turmas_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.turmas_id_seq', 14, true);
            public    
   gadohumano    false    217            �           0    0    usuarios_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.usuarios_id_seq', 6, true);
            public    
   gadohumano    false    219            �
           2606    24266    alunos alunos_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.alunos
    ADD CONSTRAINT alunos_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.alunos DROP CONSTRAINT alunos_pkey;
       public      
   gadohumano    false    198            �
           2606    24277    aten_ped aten_ped_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.aten_ped
    ADD CONSTRAINT aten_ped_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.aten_ped DROP CONSTRAINT aten_ped_pkey;
       public      
   gadohumano    false    200            �
           2606    24285    contatos contatos_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.contatos
    ADD CONSTRAINT contatos_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.contatos DROP CONSTRAINT contatos_pkey;
       public      
   gadohumano    false    202            �
           2606    24293    curriculos curriculos_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.curriculos
    ADD CONSTRAINT curriculos_pkey PRIMARY KEY (id);
 D   ALTER TABLE ONLY public.curriculos DROP CONSTRAINT curriculos_pkey;
       public      
   gadohumano    false    204            �
           2606    24304    disciplinas disciplinas_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.disciplinas
    ADD CONSTRAINT disciplinas_pkey PRIMARY KEY (id);
 F   ALTER TABLE ONLY public.disciplinas DROP CONSTRAINT disciplinas_pkey;
       public      
   gadohumano    false    207            �
           2606    24312    enderecos enderecos_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.enderecos
    ADD CONSTRAINT enderecos_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.enderecos DROP CONSTRAINT enderecos_pkey;
       public      
   gadohumano    false    209            �
           2606    24320    funcionarios funcionarios_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.funcionarios
    ADD CONSTRAINT funcionarios_pkey PRIMARY KEY (id);
 H   ALTER TABLE ONLY public.funcionarios DROP CONSTRAINT funcionarios_pkey;
       public      
   gadohumano    false    211            �
           2606    24328    matriculas matriculas_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.matriculas
    ADD CONSTRAINT matriculas_pkey PRIMARY KEY (id);
 D   ALTER TABLE ONLY public.matriculas DROP CONSTRAINT matriculas_pkey;
       public      
   gadohumano    false    213            �
           2606    24336    pessoas pessoas_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.pessoas
    ADD CONSTRAINT pessoas_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.pessoas DROP CONSTRAINT pessoas_pkey;
       public      
   gadohumano    false    215            �
           2606    24341    res_fin res_fin_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.res_fin
    ADD CONSTRAINT res_fin_pkey PRIMARY KEY (pessoa_id);
 >   ALTER TABLE ONLY public.res_fin DROP CONSTRAINT res_fin_pkey;
       public      
   gadohumano    false    216            �
           2606    24349    turmas turmas_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.turmas
    ADD CONSTRAINT turmas_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.turmas DROP CONSTRAINT turmas_pkey;
       public      
   gadohumano    false    218            �
           2606    23289 .   curriculos_turmas uk_ewg2y8ux6sp5ij8yhjlpt1d2m 
   CONSTRAINT     n   ALTER TABLE ONLY public.curriculos_turmas
    ADD CONSTRAINT uk_ewg2y8ux6sp5ij8yhjlpt1d2m UNIQUE (turmas_id);
 X   ALTER TABLE ONLY public.curriculos_turmas DROP CONSTRAINT uk_ewg2y8ux6sp5ij8yhjlpt1d2m;
       public      
   gadohumano    false    196            �
           2606    24359 $   res_fin uk_ppv6kont6dgatve83rd5pc9xn 
   CONSTRAINT     ^   ALTER TABLE ONLY public.res_fin
    ADD CONSTRAINT uk_ppv6kont6dgatve83rd5pc9xn UNIQUE (cpf);
 N   ALTER TABLE ONLY public.res_fin DROP CONSTRAINT uk_ppv6kont6dgatve83rd5pc9xn;
       public      
   gadohumano    false    216            �
           2606    24357    usuarios usuarios_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.usuarios
    ADD CONSTRAINT usuarios_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.usuarios DROP CONSTRAINT usuarios_pkey;
       public      
   gadohumano    false    220            �
           2606    24415 &   matriculas fk1o9091wci3fkpenss0fj38w3a    FK CONSTRAINT     �   ALTER TABLE ONLY public.matriculas
    ADD CONSTRAINT fk1o9091wci3fkpenss0fj38w3a FOREIGN KEY (turma_id) REFERENCES public.turmas(id);
 P   ALTER TABLE ONLY public.matriculas DROP CONSTRAINT fk1o9091wci3fkpenss0fj38w3a;
       public    
   gadohumano    false    213    218    2779            �
           2606    24385 0   disciplina_curriculo fk3scxd94ujxqmlqojvpsppeukx    FK CONSTRAINT     �   ALTER TABLE ONLY public.disciplina_curriculo
    ADD CONSTRAINT fk3scxd94ujxqmlqojvpsppeukx FOREIGN KEY (disciplina_id) REFERENCES public.curriculos(id);
 Z   ALTER TABLE ONLY public.disciplina_curriculo DROP CONSTRAINT fk3scxd94ujxqmlqojvpsppeukx;
       public    
   gadohumano    false    204    2763    205            �
           2606    24365 "   alunos fk3xvncpu3w35wsl4ty3q41liml    FK CONSTRAINT     �   ALTER TABLE ONLY public.alunos
    ADD CONSTRAINT fk3xvncpu3w35wsl4ty3q41liml FOREIGN KEY (pai_id) REFERENCES public.pessoas(id);
 L   ALTER TABLE ONLY public.alunos DROP CONSTRAINT fk3xvncpu3w35wsl4ty3q41liml;
       public    
   gadohumano    false    198    215    2773            �
           2606    24405 &   matriculas fk5swe8t3v00ykmemb4bquhkmhq    FK CONSTRAINT     �   ALTER TABLE ONLY public.matriculas
    ADD CONSTRAINT fk5swe8t3v00ykmemb4bquhkmhq FOREIGN KEY (disciplina_id) REFERENCES public.disciplinas(id);
 P   ALTER TABLE ONLY public.matriculas DROP CONSTRAINT fk5swe8t3v00ykmemb4bquhkmhq;
       public    
   gadohumano    false    213    207    2765            �
           2606    24390 (   funcionarios fk8j0vewjig3gbr07brhya1ao1r    FK CONSTRAINT     �   ALTER TABLE ONLY public.funcionarios
    ADD CONSTRAINT fk8j0vewjig3gbr07brhya1ao1r FOREIGN KEY (pessoa_id) REFERENCES public.pessoas(id);
 R   ALTER TABLE ONLY public.funcionarios DROP CONSTRAINT fk8j0vewjig3gbr07brhya1ao1r;
       public    
   gadohumano    false    211    2773    215            �
           2606    24425 #   res_fin fkaup4eig112ki6444hmblymwjk    FK CONSTRAINT     �   ALTER TABLE ONLY public.res_fin
    ADD CONSTRAINT fkaup4eig112ki6444hmblymwjk FOREIGN KEY (pessoa_id) REFERENCES public.pessoas(id);
 M   ALTER TABLE ONLY public.res_fin DROP CONSTRAINT fkaup4eig112ki6444hmblymwjk;
       public    
   gadohumano    false    2773    216    215            �
           2606    24380 /   disciplina_curriculo fkbgv38222wgqg62pyd3md0fal    FK CONSTRAINT     �   ALTER TABLE ONLY public.disciplina_curriculo
    ADD CONSTRAINT fkbgv38222wgqg62pyd3md0fal FOREIGN KEY (curriculo_id) REFERENCES public.disciplinas(id);
 Y   ALTER TABLE ONLY public.disciplina_curriculo DROP CONSTRAINT fkbgv38222wgqg62pyd3md0fal;
       public    
   gadohumano    false    205    207    2765            �
           2606    24410 &   matriculas fkhc7brq8ncrx4gkmur81obafre    FK CONSTRAINT     �   ALTER TABLE ONLY public.matriculas
    ADD CONSTRAINT fkhc7brq8ncrx4gkmur81obafre FOREIGN KEY (professor_id) REFERENCES public.funcionarios(id);
 P   ALTER TABLE ONLY public.matriculas DROP CONSTRAINT fkhc7brq8ncrx4gkmur81obafre;
       public    
   gadohumano    false    213    2769    211            �
           2606    24420 #   pessoas fklpw00nq3l85f1yu7042hpkxnl    FK CONSTRAINT     �   ALTER TABLE ONLY public.pessoas
    ADD CONSTRAINT fklpw00nq3l85f1yu7042hpkxnl FOREIGN KEY (endereco_id) REFERENCES public.enderecos(id);
 M   ALTER TABLE ONLY public.pessoas DROP CONSTRAINT fklpw00nq3l85f1yu7042hpkxnl;
       public    
   gadohumano    false    209    2767    215            �
           2606    24370 "   alunos fkm2htdug5xfj8h4f5gjfbe227p    FK CONSTRAINT     �   ALTER TABLE ONLY public.alunos
    ADD CONSTRAINT fkm2htdug5xfj8h4f5gjfbe227p FOREIGN KEY (pessoa_id) REFERENCES public.pessoas(id);
 L   ALTER TABLE ONLY public.alunos DROP CONSTRAINT fkm2htdug5xfj8h4f5gjfbe227p;
       public    
   gadohumano    false    2773    198    215            �
           2606    24375 !   alunos fkmfcqvcl0a7pksg6n6jr7xhrt    FK CONSTRAINT     �   ALTER TABLE ONLY public.alunos
    ADD CONSTRAINT fkmfcqvcl0a7pksg6n6jr7xhrt FOREIGN KEY (responsavel_pessoa_id) REFERENCES public.res_fin(pessoa_id);
 K   ALTER TABLE ONLY public.alunos DROP CONSTRAINT fkmfcqvcl0a7pksg6n6jr7xhrt;
       public    
   gadohumano    false    216    2775    198            �
           2606    24360 "   alunos fkn90vbx3lxtxpxj3cd6d8vjpyo    FK CONSTRAINT     �   ALTER TABLE ONLY public.alunos
    ADD CONSTRAINT fkn90vbx3lxtxpxj3cd6d8vjpyo FOREIGN KEY (mae_id) REFERENCES public.pessoas(id);
 L   ALTER TABLE ONLY public.alunos DROP CONSTRAINT fkn90vbx3lxtxpxj3cd6d8vjpyo;
       public    
   gadohumano    false    215    2773    198            �
           2606    24430 "   turmas fknn94mo8cnb3dakjy6hxfmvvpi    FK CONSTRAINT     �   ALTER TABLE ONLY public.turmas
    ADD CONSTRAINT fknn94mo8cnb3dakjy6hxfmvvpi FOREIGN KEY (curriculo_id) REFERENCES public.curriculos(id);
 L   ALTER TABLE ONLY public.turmas DROP CONSTRAINT fknn94mo8cnb3dakjy6hxfmvvpi;
       public    
   gadohumano    false    2763    218    204            �
           2606    24436 "   alunos fkrcwh2fp0exue37awn7mgtw6pe    FK CONSTRAINT     �   ALTER TABLE ONLY public.alunos
    ADD CONSTRAINT fkrcwh2fp0exue37awn7mgtw6pe FOREIGN KEY (turma_id) REFERENCES public.turmas(id);
 L   ALTER TABLE ONLY public.alunos DROP CONSTRAINT fkrcwh2fp0exue37awn7mgtw6pe;
       public    
   gadohumano    false    218    2779    198            �
           2606    24400 &   matriculas fkrwsrt4qf6q7fghkawume7g1ya    FK CONSTRAINT     �   ALTER TABLE ONLY public.matriculas
    ADD CONSTRAINT fkrwsrt4qf6q7fghkawume7g1ya FOREIGN KEY (aluno_id) REFERENCES public.alunos(id);
 P   ALTER TABLE ONLY public.matriculas DROP CONSTRAINT fkrwsrt4qf6q7fghkawume7g1ya;
       public    
   gadohumano    false    213    2757    198            �
           2606    24395 (   funcionarios fks4yq57d5en3re1c6q33qe0lkb    FK CONSTRAINT     �   ALTER TABLE ONLY public.funcionarios
    ADD CONSTRAINT fks4yq57d5en3re1c6q33qe0lkb FOREIGN KEY (usuario_id) REFERENCES public.usuarios(id);
 R   ALTER TABLE ONLY public.funcionarios DROP CONSTRAINT fks4yq57d5en3re1c6q33qe0lkb;
       public    
   gadohumano    false    2781    220    211            i   1   x��I  ��D�&�&P�:���E��A>s6�ɩ�\��lf����      k      x������ � �      m      x������ � �      o   t   x�3�tu�7�t��w��yřy�
i�yɉ��y%�9
�\F 5FP5�F��H�R`ʌL��AJ� J�]lJ̀J-�L@J-aJ-�)��Z��V���S�{xeJf>W� }�9:      g      x������ � �      p   |   x�-���0���0�(��d��?�Qh�V44;�54�}<��˱�Q�GBA�7x�L�MY�]Y�mY�IWҕt%=�}r�BGZ�O�Q��_����MϏw�aCVdG�d��r��?�/ ^      r     x�=�KN�0���\ �)m
�4�a)m�$ݱ1!KI�l� �@T�#�b���73��C����CQ�A*3�ў5Y���#�����K�;�!U���F4���sZC.L��#k绰�B�����<\y
�����ԾA���Z	.ٷF	F��-����2ZA&������;W�չ����I-g_�WE�l��$w�����7�$�������D�8�K?�yK�^�0�O��s	�Ը:@����&;�χF.⸄H����o������AH}�      t   �  x����n�0���Spl	�DI�(�6��q\�S��,UH�p�6m����^�'5C3F�A �����GKlm��C{��(�0�~�z��B,������I{�����I]A���r�B�J)(��58��E�r���8d����-+���#Kx�xo;ʠ������Z�jo���� U�yr)�pX��0�f<����Ҕ�Z��%Rص�a�Su�\o;�tҽ(�8ٓZ�V?"@�P3}e���m��l[��l����t���Q��0��KST����ţ�6T|K���;r��n�\#��,��]�tc�V�@@��RI(�ڜg��_;Mz�e&�
whh~]3@Y��T��ΒB��<�J{���ɬ�FOTޔ��e �ń���/&��	I��J��C�E�g�K��#sd6��"I�i�׽qv�@�3�W�8��*fBA5-����'x�\�K�x`��<�類"vm>�eۡ��!��(�_�)+�      v   G   x�Mȱ� �ڿ��"���B)�9�(��(�`BQ�e��P��T��GG�9��7paě�R'R      x   7   x�3���4�30 @�:���!���������%!�0�`�kL�^d�c���� 3R5      z   �  x���In1E��)tHJ5�;���F�*�7J����⚐'�)|������E�	.�>�?EjT�+o�Z�t�(�>ܝ���[�w�������łjW��6���E�d�Ԍ/��6�A��)�]Л��a�P{QhАb���(8�Oߤ����Mۨ/���0(��Z*��+�]����A)�7�l��5t��A�6�_Y2 [8l��n�S%TK~XI�\�6���f�S��Y�C�ݘ�²hx�]UP�pA�4�wS�%�˔��}�ǿ]�<E)j/�bS��w�Ӏ_�ٷ?ָ��r֫���a��-?��@��}�l���� � gr�>(�\���0�}�y�$&���2|�Sl����P�2��+���%�Z�˨�0~�Ӡwy�vD��D/�� �K��      {   8   x�Ź !����e�s�\�u@��RpT��r;�Lvw�j��$��^ڦ�O /�	�      }   �   x���;
�@F������wy��(6Ig'�@"̤PWd�,�Ɣ�	#d��|�al�����aRݤ�p�u��Ώ}���}8�4U���di��H�d`RP&�¦�\��KA���rd��#OA�U�HR,�D�\Yb�fSG����_������?�
�}��Ê�>4��         �   x�]�1�0Eg�0U�`,�bfq�(����n��d�^����%l����Xno�5�T�dΗ+��P�%ܼ�����-�C�`#�=���J�f��E@��4!���?nw��іI�Vwnoj�%�jdg������F��\?     