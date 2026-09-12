.class public Lio/dcloud/sdk/core/util/TidUtil;
.super Ljava/lang/Object;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getTid(Ljava/lang/String;I)Ljava/lang/String;
    .locals 19

    move-object/from16 v0, p0

    move/from16 v1, p1

    .line 1
    invoke-static {}, Lio/dcloud/p/e;->b()Lio/dcloud/p/e;

    move-result-object v2

    invoke-virtual {v2, v0}, Lio/dcloud/p/e;->a(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 2
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0

    :cond_0
    const-string v3, "sgm"

    const-string v5, "pg"

    const-string v6, "hw"

    const-string v7, "gg"

    const-string v8, "bd"

    const/4 v9, 0x7

    const/4 v10, 0x5

    const-string v11, "csj"

    const/4 v12, 0x4

    const/4 v13, 0x3

    const-string v14, "gdt"

    const-string v15, "ks"

    const/16 v16, 0x2

    const/16 v17, 0x0

    const/16 v18, -0x1

    const-string v2, "gm"

    const/4 v4, 0x1

    if-eq v1, v4, :cond_2d

    if-eq v1, v9, :cond_27

    const/16 v4, 0xf

    if-eq v1, v4, :cond_1d

    if-eq v1, v12, :cond_14

    if-eq v1, v10, :cond_f

    packed-switch v1, :pswitch_data_0

    goto/16 :goto_e

    .line 113
    :pswitch_0
    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v1

    sparse-switch v1, :sswitch_data_0

    :goto_0
    const/4 v13, -0x1

    goto :goto_1

    :sswitch_0
    invoke-virtual {v0, v14}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_4

    goto :goto_0

    :sswitch_1
    invoke-virtual {v0, v11}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    goto :goto_0

    :cond_1
    const/4 v13, 0x2

    goto :goto_1

    :sswitch_2
    invoke-virtual {v0, v15}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_2

    goto :goto_0

    :cond_2
    const/4 v13, 0x1

    goto :goto_1

    :sswitch_3
    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_3

    goto :goto_0

    :cond_3
    const/4 v13, 0x0

    :cond_4
    :goto_1
    packed-switch v13, :pswitch_data_1

    goto/16 :goto_e

    .line 115
    :pswitch_1
    const-string v0, "103"

    return-object v0

    .line 117
    :pswitch_2
    const-string v0, "104"

    return-object v0

    .line 119
    :pswitch_3
    const-string v0, "105"

    return-object v0

    .line 121
    :pswitch_4
    const-string v0, "106"

    return-object v0

    .line 122
    :pswitch_5
    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v1

    sparse-switch v1, :sswitch_data_1

    :goto_2
    const/4 v2, -0x1

    goto/16 :goto_3

    :sswitch_4
    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_5

    goto :goto_2

    :cond_5
    const/16 v2, 0x9

    goto/16 :goto_3

    :sswitch_5
    invoke-virtual {v0, v14}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_6

    goto :goto_2

    :cond_6
    const/16 v2, 0x8

    goto :goto_3

    :sswitch_6
    invoke-virtual {v0, v11}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_7

    goto :goto_2

    :cond_7
    const/4 v2, 0x7

    goto :goto_3

    :sswitch_7
    const-string v1, "wm"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_8

    goto :goto_2

    :cond_8
    const/4 v2, 0x6

    goto :goto_3

    :sswitch_8
    invoke-virtual {v0, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_9

    goto :goto_2

    :cond_9
    const/4 v2, 0x5

    goto :goto_3

    :sswitch_9
    invoke-virtual {v0, v15}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_a

    goto :goto_2

    :cond_a
    const/4 v2, 0x4

    goto :goto_3

    :sswitch_a
    invoke-virtual {v0, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_b

    goto :goto_2

    :cond_b
    const/4 v2, 0x3

    goto :goto_3

    :sswitch_b
    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_c

    goto :goto_2

    :cond_c
    const/4 v2, 0x2

    goto :goto_3

    :sswitch_c
    invoke-virtual {v0, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_d

    goto :goto_2

    :cond_d
    const/4 v2, 0x1

    goto :goto_3

    :sswitch_d
    invoke-virtual {v0, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_e

    goto :goto_2

    :cond_e
    const/4 v2, 0x0

    :goto_3
    packed-switch v2, :pswitch_data_2

    goto/16 :goto_e

    .line 130
    :pswitch_6
    const-string v0, "86"

    return-object v0

    .line 131
    :pswitch_7
    const-string v0, "83"

    return-object v0

    .line 133
    :pswitch_8
    const-string v0, "84"

    return-object v0

    .line 145
    :pswitch_9
    const-string v0, "140"

    return-object v0

    .line 149
    :pswitch_a
    const-string v0, "1211"

    return-object v0

    .line 150
    :pswitch_b
    const-string v0, "85"

    return-object v0

    .line 156
    :pswitch_c
    const-string v0, "87"

    return-object v0

    .line 158
    :pswitch_d
    const-string v0, "89"

    return-object v0

    .line 162
    :pswitch_e
    const-string v0, "1210"

    return-object v0

    .line 163
    :pswitch_f
    const-string v0, "88"

    return-object v0

    .line 252
    :cond_f
    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v1

    sparse-switch v1, :sswitch_data_2

    :goto_4
    const/16 v16, -0x1

    goto :goto_5

    :sswitch_e
    invoke-virtual {v0, v14}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_12

    goto :goto_4

    :sswitch_f
    invoke-virtual {v0, v15}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_10

    goto :goto_4

    :cond_10
    const/16 v16, 0x1

    goto :goto_5

    :sswitch_10
    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_11

    goto :goto_4

    :cond_11
    const/16 v16, 0x0

    :cond_12
    :goto_5
    packed-switch v16, :pswitch_data_3

    .line 262
    :pswitch_10
    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_13

    goto/16 :goto_e

    .line 264
    :cond_13
    const-string v0, "1002111"

    return-object v0

    .line 265
    :pswitch_11
    const-string v0, "1501"

    return-object v0

    .line 267
    :pswitch_12
    const-string v0, "1502"

    return-object v0

    .line 269
    :pswitch_13
    const-string v0, "1503"

    return-object v0

    .line 270
    :cond_14
    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v1

    sparse-switch v1, :sswitch_data_3

    :goto_6
    const/4 v4, -0x1

    goto :goto_7

    :sswitch_11
    invoke-virtual {v0, v14}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_15

    goto :goto_6

    :cond_15
    const/4 v4, 0x7

    goto :goto_7

    :sswitch_12
    invoke-virtual {v0, v11}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_16

    goto :goto_6

    :cond_16
    const/4 v4, 0x6

    goto :goto_7

    :sswitch_13
    invoke-virtual {v0, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_17

    goto :goto_6

    :cond_17
    const/4 v4, 0x5

    goto :goto_7

    :sswitch_14
    invoke-virtual {v0, v15}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_18

    goto :goto_6

    :cond_18
    const/4 v4, 0x4

    goto :goto_7

    :sswitch_15
    invoke-virtual {v0, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_19

    goto :goto_6

    :cond_19
    const/4 v4, 0x3

    goto :goto_7

    :sswitch_16
    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1a

    goto :goto_6

    :cond_1a
    const/4 v4, 0x2

    goto :goto_7

    :sswitch_17
    invoke-virtual {v0, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1b

    goto :goto_6

    :cond_1b
    const/4 v4, 0x1

    goto :goto_7

    :sswitch_18
    invoke-virtual {v0, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1c

    goto :goto_6

    :cond_1c
    const/4 v4, 0x0

    :goto_7
    packed-switch v4, :pswitch_data_4

    goto/16 :goto_e

    .line 272
    :pswitch_14
    const-string v0, "72"

    return-object v0

    .line 274
    :pswitch_15
    const-string v0, "73"

    return-object v0

    .line 286
    :pswitch_16
    const-string v0, "1201"

    return-object v0

    .line 287
    :pswitch_17
    const-string v0, "76"

    return-object v0

    .line 289
    :pswitch_18
    const-string v0, "77"

    return-object v0

    .line 293
    :pswitch_19
    const-string v0, "79"

    return-object v0

    .line 295
    :pswitch_1a
    const-string v0, "1200"

    return-object v0

    .line 296
    :pswitch_1b
    const-string v0, "78"

    return-object v0

    .line 370
    :cond_1d
    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v1

    sparse-switch v1, :sswitch_data_4

    :goto_8
    const/4 v2, -0x1

    goto :goto_9

    :sswitch_19
    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1e

    goto :goto_8

    :cond_1e
    const/16 v2, 0x8

    goto :goto_9

    :sswitch_1a
    invoke-virtual {v0, v14}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1f

    goto :goto_8

    :cond_1f
    const/4 v2, 0x7

    goto :goto_9

    :sswitch_1b
    invoke-virtual {v0, v11}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_20

    goto :goto_8

    :cond_20
    const/4 v2, 0x6

    goto :goto_9

    :sswitch_1c
    invoke-virtual {v0, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_21

    goto :goto_8

    :cond_21
    const/4 v2, 0x5

    goto :goto_9

    :sswitch_1d
    invoke-virtual {v0, v15}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_22

    goto :goto_8

    :cond_22
    const/4 v2, 0x4

    goto :goto_9

    :sswitch_1e
    invoke-virtual {v0, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_23

    goto :goto_8

    :cond_23
    const/4 v2, 0x3

    goto :goto_9

    :sswitch_1f
    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_24

    goto :goto_8

    :cond_24
    const/4 v2, 0x2

    goto :goto_9

    :sswitch_20
    invoke-virtual {v0, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_25

    goto :goto_8

    :cond_25
    const/4 v2, 0x1

    goto :goto_9

    :sswitch_21
    invoke-virtual {v0, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_26

    goto :goto_8

    :cond_26
    const/4 v2, 0x0

    :goto_9
    packed-switch v2, :pswitch_data_5

    goto/16 :goto_e

    .line 384
    :pswitch_1c
    const-string v0, "129"

    return-object v0

    .line 385
    :pswitch_1d
    const-string v0, "123"

    return-object v0

    .line 387
    :pswitch_1e
    const-string v0, "124"

    return-object v0

    .line 401
    :pswitch_1f
    const-string v0, "1231"

    return-object v0

    .line 402
    :pswitch_20
    const-string v0, "125"

    return-object v0

    .line 404
    :pswitch_21
    const-string v0, "126"

    return-object v0

    .line 408
    :pswitch_22
    const-string v0, "128"

    return-object v0

    .line 412
    :pswitch_23
    const-string v0, "1230"

    return-object v0

    .line 413
    :pswitch_24
    const-string v0, "127"

    return-object v0

    .line 414
    :cond_27
    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v1

    sparse-switch v1, :sswitch_data_5

    :goto_a
    const/4 v12, -0x1

    goto :goto_b

    :sswitch_22
    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_2c

    goto :goto_a

    :sswitch_23
    invoke-virtual {v0, v14}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_28

    goto :goto_a

    :cond_28
    const/4 v12, 0x3

    goto :goto_b

    :sswitch_24
    invoke-virtual {v0, v11}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_29

    goto :goto_a

    :cond_29
    const/4 v12, 0x2

    goto :goto_b

    :sswitch_25
    invoke-virtual {v0, v15}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_2a

    goto :goto_a

    :cond_2a
    const/4 v12, 0x1

    goto :goto_b

    :sswitch_26
    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_2b

    goto :goto_a

    :cond_2b
    const/4 v12, 0x0

    :cond_2c
    :goto_b
    packed-switch v12, :pswitch_data_6

    goto/16 :goto_e

    .line 424
    :pswitch_25
    const-string v0, "97"

    return-object v0

    .line 425
    :pswitch_26
    const-string v0, "93"

    return-object v0

    .line 427
    :pswitch_27
    const-string v0, "94"

    return-object v0

    .line 429
    :pswitch_28
    const-string v0, "95"

    return-object v0

    .line 431
    :pswitch_29
    const-string v0, "96"

    return-object v0

    .line 432
    :cond_2d
    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v1

    sparse-switch v1, :sswitch_data_6

    :goto_c
    const/4 v2, -0x1

    goto :goto_d

    :sswitch_27
    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_2e

    goto :goto_c

    :cond_2e
    const/16 v2, 0x8

    goto :goto_d

    :sswitch_28
    invoke-virtual {v0, v14}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_2f

    goto :goto_c

    :cond_2f
    const/4 v2, 0x7

    goto :goto_d

    :sswitch_29
    invoke-virtual {v0, v11}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_30

    goto :goto_c

    :cond_30
    const/4 v2, 0x6

    goto :goto_d

    :sswitch_2a
    invoke-virtual {v0, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_31

    goto :goto_c

    :cond_31
    const/4 v2, 0x5

    goto :goto_d

    :sswitch_2b
    invoke-virtual {v0, v15}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_32

    goto :goto_c

    :cond_32
    const/4 v2, 0x4

    goto :goto_d

    :sswitch_2c
    invoke-virtual {v0, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_33

    goto :goto_c

    :cond_33
    const/4 v2, 0x3

    goto :goto_d

    :sswitch_2d
    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_34

    goto :goto_c

    :cond_34
    const/4 v2, 0x2

    goto :goto_d

    :sswitch_2e
    invoke-virtual {v0, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_35

    goto :goto_c

    :cond_35
    const/4 v2, 0x1

    goto :goto_d

    :sswitch_2f
    invoke-virtual {v0, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_36

    goto :goto_c

    :cond_36
    const/4 v2, 0x0

    :goto_d
    packed-switch v2, :pswitch_data_7

    .line 522
    :goto_e
    const-string v0, ""

    return-object v0

    .line 523
    :pswitch_2a
    const-string v0, "110"

    return-object v0

    .line 524
    :pswitch_2b
    const-string v0, "67"

    return-object v0

    .line 526
    :pswitch_2c
    const-string v0, "68"

    return-object v0

    .line 540
    :pswitch_2d
    const-string v0, "1221"

    return-object v0

    .line 541
    :pswitch_2e
    const-string v0, "75"

    return-object v0

    .line 545
    :pswitch_2f
    const-string v0, "130"

    return-object v0

    .line 549
    :pswitch_30
    const-string v0, "132"

    return-object v0

    .line 551
    :pswitch_31
    const-string v0, "1220"

    return-object v0

    .line 552
    :pswitch_32
    const-string v0, "131"

    return-object v0

    nop

    :pswitch_data_0
    .packed-switch 0x9
        :pswitch_5
        :pswitch_0
        :pswitch_10
    .end packed-switch

    :sswitch_data_0
    .sparse-switch
        0xce6 -> :sswitch_3
        0xd68 -> :sswitch_2
        0x181fa -> :sswitch_1
        0x18f37 -> :sswitch_0
    .end sparse-switch

    :pswitch_data_1
    .packed-switch 0x0
        :pswitch_4
        :pswitch_3
        :pswitch_2
        :pswitch_1
    .end packed-switch

    :sswitch_data_1
    .sparse-switch
        0xc42 -> :sswitch_d
        0xce0 -> :sswitch_c
        0xce6 -> :sswitch_b
        0xd0f -> :sswitch_a
        0xd68 -> :sswitch_9
        0xdf7 -> :sswitch_8
        0xed6 -> :sswitch_7
        0x181fa -> :sswitch_6
        0x18f37 -> :sswitch_5
        0x1bc99 -> :sswitch_4
    .end sparse-switch

    :pswitch_data_2
    .packed-switch 0x0
        :pswitch_f
        :pswitch_e
        :pswitch_d
        :pswitch_c
        :pswitch_b
        :pswitch_a
        :pswitch_9
        :pswitch_8
        :pswitch_7
        :pswitch_6
    .end packed-switch

    :sswitch_data_2
    .sparse-switch
        0xce6 -> :sswitch_10
        0xd68 -> :sswitch_f
        0x18f37 -> :sswitch_e
    .end sparse-switch

    :pswitch_data_3
    .packed-switch 0x0
        :pswitch_13
        :pswitch_12
        :pswitch_11
    .end packed-switch

    :sswitch_data_3
    .sparse-switch
        0xc42 -> :sswitch_18
        0xce0 -> :sswitch_17
        0xce6 -> :sswitch_16
        0xd0f -> :sswitch_15
        0xd68 -> :sswitch_14
        0xdf7 -> :sswitch_13
        0x181fa -> :sswitch_12
        0x18f37 -> :sswitch_11
    .end sparse-switch

    :pswitch_data_4
    .packed-switch 0x0
        :pswitch_1b
        :pswitch_1a
        :pswitch_19
        :pswitch_18
        :pswitch_17
        :pswitch_16
        :pswitch_15
        :pswitch_14
    .end packed-switch

    :sswitch_data_4
    .sparse-switch
        0xc42 -> :sswitch_21
        0xce0 -> :sswitch_20
        0xce6 -> :sswitch_1f
        0xd0f -> :sswitch_1e
        0xd68 -> :sswitch_1d
        0xdf7 -> :sswitch_1c
        0x181fa -> :sswitch_1b
        0x18f37 -> :sswitch_1a
        0x1bc99 -> :sswitch_19
    .end sparse-switch

    :pswitch_data_5
    .packed-switch 0x0
        :pswitch_24
        :pswitch_23
        :pswitch_22
        :pswitch_21
        :pswitch_20
        :pswitch_1f
        :pswitch_1e
        :pswitch_1d
        :pswitch_1c
    .end packed-switch

    :sswitch_data_5
    .sparse-switch
        0xce6 -> :sswitch_26
        0xd68 -> :sswitch_25
        0x181fa -> :sswitch_24
        0x18f37 -> :sswitch_23
        0x1bc99 -> :sswitch_22
    .end sparse-switch

    :pswitch_data_6
    .packed-switch 0x0
        :pswitch_29
        :pswitch_28
        :pswitch_27
        :pswitch_26
        :pswitch_25
    .end packed-switch

    :sswitch_data_6
    .sparse-switch
        0xc42 -> :sswitch_2f
        0xce0 -> :sswitch_2e
        0xce6 -> :sswitch_2d
        0xd0f -> :sswitch_2c
        0xd68 -> :sswitch_2b
        0xdf7 -> :sswitch_2a
        0x181fa -> :sswitch_29
        0x18f37 -> :sswitch_28
        0x1bc99 -> :sswitch_27
    .end sparse-switch

    :pswitch_data_7
    .packed-switch 0x0
        :pswitch_32
        :pswitch_31
        :pswitch_30
        :pswitch_2f
        :pswitch_2e
        :pswitch_2d
        :pswitch_2c
        :pswitch_2b
        :pswitch_2a
    .end packed-switch
.end method
