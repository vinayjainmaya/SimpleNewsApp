package com.vinaymj.news.headline.domain

import com.vinaymj.news.headline.domain.model.Article
import com.vinaymj.news.headline.domain.model.News
import com.vinaymj.news.headline.domain.model.Source


val mockArticle1 = Article(
    author = "Maryam Zakir-Hussain",
    title = "Energy news – live: Britain to face three-hour blackouts if gas imports stall - The Independent",
    content = "Government working with Ofgem and National Grid to reduce energy use, climate minister says\r\nThe government is supporting Ofgem to develop ways for business and consumers to reduce energy use at peak… [+999 chars]",
    description = "Prime minister rules out energy-saving information campaign",
    publishedAt = "2022-10-07T08:42:41Z",
    source = Source(
        id = "bbc-news",
        name = "BBC News"
    ),
    urlToImage = "https://static.independent.co.uk/2022/10/06/14/05dc029120b460318811caf97e2013e5Y29udGVudHNlYXJjaGFwaSwxNjY1MTMzOTM1-2.68470538.jpg?quality=75&width=1200&auto=webp",
    url = "https://www.independent.co.uk/news/uk/home-news/uk-blackout-energy-power-cut-gas-electricity-latest-b2197565.html"
)

val mockArticle2 = Article(
    author = "Kaamil Ahmed",
    title = "Health workers among dead in Ugandan Ebola outbreak - The Guardian",
    content = "It seems like a normal day in Mubende, central Uganda. Shops remain open, children are at school and public gatherings are allowed, provided people remain socially distant.\\r\\nThe ambulances that whisk… [+4168 chars]",
    description = "MSF calls situation ‘very serious’ as east African country grapples with outbreak of Sudan strain of virus, for which no vaccine exists",
    publishedAt = "2022-10-07T08:07:00Z",
    source = Source(
        id = "The Guardian",
        name = "The Guardian"
    ),
    urlToImage = "https://i.guim.co.uk/img/media/0d692d1cfb7f1ff201303c096b87c0e8dc284355/0_426_6389_3833/master/6389.jpg?width=1200&height=630&quality=85&auto=format&fit=crop&overlay-align=bottom%2Cleft&overlay-width=100p&overlay-base64=L2ltZy9zdGF0aWMvb3ZlcmxheXMvdGctZGVmYXVsdC5wbmc&enable=upscale&s=efa8b569ee738538f580674def8edb44",
    url = "https://www.theguardian.com/global-development/2022/oct/07/health-workers-among-dead-in-ugandan-ebola-outbreak"
)

val mockUkTopHeadline = News(
    status = "ok",
    totalResults = 2,
    articles = listOf(
        mockArticle1,
        mockArticle2
    )
)

val mockUkTopHeadlinesJson = "Grabage\n" +
        "\n" +
        "{\n" +
        "  \"status\": \"ok\",\n" +
        "  \"totalResults\": 38,\n" +
        "  \"articles\": [\n" +
        "    {\n" +
        "      \"source\": {\n" +
        "        \"id\": \"independent\",\n" +
        "        \"name\": \"Independent\"\n" +
        "      },\n" +
        "      \"author\": \"Maryam Zakir-Hussain\",\n" +
        "      \"title\": \"Energy news – live: Britain to face three-hour blackouts if gas imports stall - The Independent\",\n" +
        "      \"description\": \"Prime minister rules out energy-saving information campaign\",\n" +
        "      \"url\": \"https://www.independent.co.uk/news/uk/home-news/uk-blackout-energy-power-cut-gas-electricity-latest-b2197565.html\",\n" +
        "      \"urlToImage\": \"https://static.independent.co.uk/2022/10/06/14/05dc029120b460318811caf97e2013e5Y29udGVudHNlYXJjaGFwaSwxNjY1MTMzOTM1-2.68470538.jpg?quality=75&width=1200&auto=webp\",\n" +
        "      \"publishedAt\": \"2022-10-07T08:42:41Z\",\n" +
        "      \"content\": \"Government working with Ofgem and National Grid to reduce energy use, climate minister says\\r\\nThe government is supporting Ofgem to develop ways for business and consumers to reduce energy use at peak… [+999 chars]\"\n" +
        "    },\n" +
        "    {\n" +
        "      \"source\": {\n" +
        "        \"id\": \"bbc-news\",\n" +
        "        \"name\": \"BBC News\"\n" +
        "      },\n" +
        "      \"author\": \"https://www.facebook.com/bbcnews\",\n" +
        "      \"title\": \"Avanti West Coast told to drastically improve rail services - BBC\",\n" +
        "      \"description\": \"Train operator is given a short-term extension to continue running services on the west coast mainline.\",\n" +
        "      \"url\": \"https://www.bbc.co.uk/news/business-63169383\",\n" +
        "      \"urlToImage\": \"https://ichef.bbci.co.uk/news/1024/branded_news/17DA6/production/_126620779_gettyimages-1319023074.jpg\",\n" +
        "      \"publishedAt\": \"2022-10-07T08:35:00Z\",\n" +
        "      \"content\": \"Rail firm Avanti West Coast has been warned it needs to \\\"drastically improve services\\\" after its contract to run the London to Glasgow line was extended by just six months. \\r\\nThe decision means it wi… [+4656 chars]\"\n" +
        "    },\n" +
        "    {\n" +
        "      \"source\": {\n" +
        "        \"id\": null,\n" +
        "        \"name\": \"Telegraph.co.uk\"\n" +
        "      },\n" +
        "      \"author\": null,\n" +
        "      \"title\": \"Russia-Ukraine war latest: World faces risk of nuclear 'Armageddon' as Putin not bluffing, Biden warns - The Telegraph\",\n" +
        "      \"description\": \"Joe Biden on Thursday warned the risk of nuclear &quot;Armageddon&quot; was at its highest level since the 1962 Cuban Missile Crisis, as Russia hinted at the possibility of using tactical nuclear weapons after suffering major setbacks in its invasion of Ukrai…\",\n" +
        "      \"url\": \"https://www.telegraph.co.uk/world-news/2022/10/07/ukraine-news-latest-advances-war-russia-nuclear-putin/\",\n" +
        "      \"urlToImage\": \"https://www.telegraph.co.uk/content/dam/world-news/2022/10/07/TELEMMGLPICT000289064574_trans_NvBQzQNjv4BqkUE_BTgBOQu3VWKvpDGX9eJuIVaCpI5ozSxbwBJXXMI.jpeg?impolicy=logo-overlay\",\n" +
        "      \"publishedAt\": \"2022-10-07T08:08:19Z\",\n" +
        "      \"content\": \"Russias defence minister, General Sergei Shoigu, has been urged to kill himself over defeats on the battlefield in a shocking broadside by one of the Kremlins own officials.\\r\\nKirill Stremousov, appoi… [+466 chars]\"\n" +
        "    },\n" +
        "    {\n" +
        "      \"source\": {\n" +
        "        \"id\": null,\n" +
        "        \"name\": \"The Guardian\"\n" +
        "      },\n" +
        "      \"author\": \"Kaamil Ahmed\",\n" +
        "      \"title\": \"Health workers among dead in Ugandan Ebola outbreak - The Guardian\",\n" +
        "      \"description\": \"MSF calls situation ‘very serious’ as east African country grapples with outbreak of Sudan strain of virus, for which no vaccine exists\",\n" +
        "      \"url\": \"https://www.theguardian.com/global-development/2022/oct/07/health-workers-among-dead-in-ugandan-ebola-outbreak\",\n" +
        "      \"urlToImage\": \"https://i.guim.co.uk/img/media/0d692d1cfb7f1ff201303c096b87c0e8dc284355/0_426_6389_3833/master/6389.jpg?width=1200&height=630&quality=85&auto=format&fit=crop&overlay-align=bottom%2Cleft&overlay-width=100p&overlay-base64=L2ltZy9zdGF0aWMvb3ZlcmxheXMvdGctZGVmYXVsdC5wbmc&enable=upscale&s=efa8b569ee738538f580674def8edb44\",\n" +
        "      \"publishedAt\": \"2022-10-07T08:07:00Z\",\n" +
        "      \"content\": \"It seems like a normal day in Mubende, central Uganda. Shops remain open, children are at school and public gatherings are allowed, provided people remain socially distant.\\r\\nThe ambulances that whisk… [+4168 chars]\"\n" +
        "    },\n" +
        "    {\n" +
        "      \"source\": {\n" +
        "        \"id\": null,\n" +
        "        \"name\": \"The Guardian\"\n" +
        "      },\n" +
        "      \"author\": \"Mark Sweney\",\n" +
        "      \"title\": \"UK house prices expected to fall as mortgage rates soar - The Guardian\",\n" +
        "      \"description\": \"Average house price fell by 0.1% month on month in September to £293,835, says Halifax\",\n" +
        "      \"url\": \"https://www.theguardian.com/business/2022/oct/07/uk-house-prices-expected-to-fall-as-mortgage-rates-soar\",\n" +
        "      \"urlToImage\": \"https://i.guim.co.uk/img/media/5b16ecb94eb2dbf079eebd6294f82c120eb5da5b/14_16_4445_2669/master/4445.jpg?width=1200&height=630&quality=85&auto=format&fit=crop&overlay-align=bottom%2Cleft&overlay-width=100p&overlay-base64=L2ltZy9zdGF0aWMvb3ZlcmxheXMvdGctZGVmYXVsdC5wbmc&enable=upscale&s=8d9570ea542813d772cd447aa48cac20\",\n" +
        "      \"publishedAt\": \"2022-10-07T07:49:00Z\",\n" +
        "      \"content\": \"Rising mortgage costs and the broader cost of living crisis will push UK house prices down more sharply in the coming months, according to Halifax, after prices dipped 0.1% in September.\\r\\nHalifax sai… [+2646 chars]\"\n" +
        "    },\n" +
        "    {\n" +
        "      \"source\": {\n" +
        "        \"id\": \"talksport\",\n" +
        "        \"name\": \"TalkSport\"\n" +
        "      },\n" +
        "      \"author\": \"Jordan Ellis and Michael Benson, Jordan Ellis, Michael Benson\",\n" +
        "      \"title\": \"Chris Eubank Jr vs Conor Benn called OFF and won't take place on Saturday night following Benn's positive d... - talkSPORT\",\n" +
        "      \"description\": \"\",\n" +
        "      \"url\": \"https://talksport.com/sport/boxing/1211441/chris-eubank-jr-vs-conor-benn-off-postponed-drugs/\",\n" +
        "      \"urlToImage\": \"https://talksport.com/wp-content/uploads/sites/5/2022/10/ChrisEubankJrConorBenn.jpg?strip=all&quality=100&w=1200&h=800&crop=1\",\n" +
        "      \"publishedAt\": \"2022-10-07T07:30:00Z\",\n" +
        "      \"content\": \"Chris Eubank vs Conor Benn has been postponed following the latter’s positive drugs test.\\r\\nNews broke on Wednesday that Benn had tested positive for the banned substance clomifene in August.\\r\\nBenn te… [+4683 chars]\"\n" +
        "    },\n" +
        "    {\n" +
        "      \"source\": {\n" +
        "        \"id\": null,\n" +
        "        \"name\": \"Sky Sports\"\n" +
        "      },\n" +
        "      \"author\": \"Sky Sports\",\n" +
        "      \"title\": \"Japanese GP: George Russell leads Lewis Hamilton as Mercedes seal one-two in wet Practice Two - Sky Sports\",\n" +
        "      \"description\": \"George Russell led a one-two from team-mate Lewis Hamilton as Mercedes delivered impressive speed in a wet second practice at the Japanese Grand Prix.\",\n" +
        "      \"url\": \"https://www.skysports.com/f1/news/12433/12714216/japanese-gp-george-russell-leads-lewis-hamilton-as-mercedes-seal-one-two-in-wet-practice-two\",\n" +
        "      \"urlToImage\": \"https://e0.365dm.com/22/10/1600x900/skysports-george-russell-mercedes_5922876.jpg\",\n" +
        "      \"publishedAt\": \"2022-10-07T06:55:36Z\",\n" +
        "      \"content\": \"Please use Chrome browser for a more accessible video player\\r\\nSky F1's David Croft and Karun Chandhok discuss the big talking points from Friday's practice at Suzuka\\r\\nSky F1's David Croft and Karun C… [+4605 chars]\"\n" +
        "    },\n" +
        "    {\n" +
        "      \"source\": {\n" +
        "        \"id\": null,\n" +
        "        \"name\": \"Express\"\n" +
        "      },\n" +
        "      \"author\": \"Joe Krishnan\",\n" +
        "      \"title\": \"Cristiano Ronaldo has miss of the season contender as Man Utd woes continue against Omonia - Express\",\n" +
        "      \"description\": \"Cristiano Ronaldo was guilty of a terrible attempt on goal as his goalscoring woes rumble on.\",\n" +
        "      \"url\": \"https://www.express.co.uk/sport/football/1679329/Cristiano-Ronaldo-Man-Utd-misses-open-goal-Europa-League-Omonia\",\n" +
        "      \"urlToImage\": \"https://cdn.images.express.co.uk/img/dynamic/67/1200x712/4326398.jpg?r=1665122212776\",\n" +
        "      \"publishedAt\": \"2022-10-07T06:28:39Z\",\n" +
        "      \"content\": \"Cristiano Ronaldo was guilty of one of the misses of the season after somehow failing to score for Manchester United in their Europa League tie against Omonia. The Portuguese superstar was presented … [+1967 chars]\"\n" +
        "    },\n" +
        "    {\n" +
        "      \"source\": {\n" +
        "        \"id\": null,\n" +
        "        \"name\": \"The Guardian\"\n" +
        "      },\n" +
        "      \"author\": \"Rebecca Ratcliffe\",\n" +
        "      \"title\": \"‘I saw my grandson’s name and I fainted’: grief engulfs town after Thailand nursery attack - The Guardian\",\n" +
        "      \"description\": \"Families tell of the moment they heard about gun and knife attack that killed 37 people, most of them children\",\n" +
        "      \"url\": \"https://www.theguardian.com/world/2022/oct/07/i-saw-my-grandsons-name-and-i-fainted-grief-engulfs-town-after-thailand-nursery-attack\",\n" +
        "      \"urlToImage\": \"https://i.guim.co.uk/img/media/461207fe304f48e3a8e85d070d34f476264efbf0/0_172_5147_3089/master/5147.jpg?width=1200&height=630&quality=85&auto=format&fit=crop&overlay-align=bottom%2Cleft&overlay-width=100p&overlay-base64=L2ltZy9zdGF0aWMvb3ZlcmxheXMvdGctZGVmYXVsdC5wbmc&enable=upscale&s=fad383eb51ad142dbf660016b49c7a94\",\n" +
        "      \"publishedAt\": \"2022-10-07T06:18:00Z\",\n" +
        "      \"content\": \"White sheets were pinned across the entrance to the childrens centre in Nong Bua Lamphu on Friday morning, shielding the site from view. On the nurserys front steps, white flowers had been left as tr… [+4399 chars]\"\n" +
        "    },\n" +
        "    {\n" +
        "      \"source\": {\n" +
        "        \"id\": null,\n" +
        "        \"name\": \"The Guardian\"\n" +
        "      },\n" +
        "      \"author\": \"Sian Cain\",\n" +
        "      \"title\": \"Chris Pratt's Mario voice was doomed before anyone had even heard it - The Guardian\",\n" +
        "      \"description\": \"We were promised a voice ‘unlike anything you’ve heard in the Mario world before’. In The Super Mario Bros film, we got Pratt doing Paulie Walnuts instead\",\n" +
        "      \"url\": \"https://www.theguardian.com/film/2022/oct/07/chris-pratts-mario-voice-was-doomed-before-anyone-had-even-heard-it\",\n" +
        "      \"urlToImage\": \"https://i.guim.co.uk/img/media/403565c5e1a5816946b2a65655f1f7635b0bff0b/304_151_1311_786/master/1311.jpg?width=1200&height=630&quality=85&auto=format&fit=crop&overlay-align=bottom%2Cleft&overlay-width=100p&overlay-base64=L2ltZy9zdGF0aWMvb3ZlcmxheXMvdGctZGVmYXVsdC5wbmc&enable=upscale&s=bc8cd28dab82b6875d4e06fefbc8a9f9\",\n" +
        "      \"publishedAt\": \"2022-10-07T05:04:00Z\",\n" +
        "      \"content\": \"There are certain seminal roles of stage and screen that all actors crave to play in their lifetimes. King Lear. John Proctor. Lady Macbeth. Willy Loman. Hannibal Lecter. And of course, Mario.\\r\\nCharl… [+4527 chars]\"\n" +
        "    },\n" +
        "    {\n" +
        "      \"source\": {\n" +
        "        \"id\": null,\n" +
        "        \"name\": \"The Guardian\"\n" +
        "      },\n" +
        "      \"author\": \"Alexandra Topping\",\n" +
        "      \"title\": \"Nursery for under-twos costs parents in England 65% of wage - The Guardian\",\n" +
        "      \"description\": \"Number of women not working to look after family has risen by 5% in past year\",\n" +
        "      \"url\": \"https://www.theguardian.com/money/2022/oct/07/nursery-under-twos-costs-parents-england-65-percent-wage\",\n" +
        "      \"urlToImage\": \"https://i.guim.co.uk/img/media/cb92bd30b6fb50d2e62f6fdf28b5588c89a150cd/0_124_4000_2400/master/4000.jpg?width=1200&height=630&quality=85&auto=format&fit=crop&overlay-align=bottom%2Cleft&overlay-width=100p&overlay-base64=L2ltZy9zdGF0aWMvb3ZlcmxheXMvdGctZGVmYXVsdC5wbmc&enable=upscale&s=3d1ea57a62c9387f9836152c387260d2\",\n" +
        "      \"publishedAt\": \"2022-10-07T05:01:00Z\",\n" +
        "      \"content\": \"Full-time nursery for children under the age of two costs almost two-thirds of a parents weekly take-home pay in England, according to new analysis.\\r\\nParents in Scotland fare slightly better, paying … [+3600 chars]\"\n" +
        "    },\n" +
        "    {\n" +
        "      \"source\": {\n" +
        "        \"id\": null,\n" +
        "        \"name\": \"Telegraph.co.uk\"\n" +
        "      },\n" +
        "      \"author\": null,\n" +
        "      \"title\": \"Four-day week workers face huge pay cuts - The Telegraph\",\n" +
        "      \"description\": \"Only a tiny number of companies plan to reduce hours while maintaining pay\",\n" +
        "      \"url\": \"https://www.telegraph.co.uk/business/2022/10/07/four-day-week-workers-face-huge-pay-cuts/\",\n" +
        "      \"urlToImage\": \"https://www.telegraph.co.uk/content/dam/business/2022/10/06/TELEMMGLPICT000305946501_trans_NvBQzQNjv4BqgsaO8O78rhmZrDxTlQBjdGLvJF5WfpqnBZShRL_tOZw.jpeg?impolicy=logo-overlay\",\n" +
        "      \"publishedAt\": \"2022-10-07T05:00:00Z\",\n" +
        "      \"content\": \"Workers moving to a four-day week are facing big wage cuts as only 1pc of companies plan to offer full pay for reduced hours.\\r\\nA third of companies expect most workers to be on a four-day week within… [+1813 chars]\"\n" +
        "    },\n" +
        "    {\n" +
        "      \"source\": {\n" +
        "        \"id\": null,\n" +
        "        \"name\": \"The Guardian\"\n" +
        "      },\n" +
        "      \"author\": \"Xan Brooks\",\n" +
        "      \"title\": \"Jamie Lee Curtis on Halloween Ends: ‘Laurie Strode is a feminist hero’ - The Guardian\",\n" +
        "      \"description\": \"It is 44 years since she first played Strode in the film that wrote the slasher flick template. As the franchise comes to a finale, Curtis and directors John Carpenter and David Gordon Green discuss growth, trauma – and closure\",\n" +
        "      \"url\": \"https://www.theguardian.com/film/2022/oct/07/jamie-lee-curtis-on-halloween-ends-laurie-strode-is-a-feminist-hero\",\n" +
        "      \"urlToImage\": \"https://i.guim.co.uk/img/media/ad612ad2d222a97f14413f09e3c564a2249d3fb4/1187_102_2748_1649/master/2748.jpg?width=1200&height=630&quality=85&auto=format&fit=crop&overlay-align=bottom%2Cleft&overlay-width=100p&overlay-base64=L2ltZy9zdGF0aWMvb3ZlcmxheXMvdGctZGVmYXVsdC5wbmc&enable=upscale&s=ca8d13c39fd4e41134d9a6cf13f52f27\",\n" +
        "      \"publishedAt\": \"2022-10-07T05:00:00Z\",\n" +
        "      \"content\": \"She is the hardy perennial of all-American horror, its blood-drenched prom queen, the so-called final girl. In the closing minutes of 1978s Halloween, teenage Laurie Strode is stabbed in the arm and … [+10689 chars]\"\n" +
        "    },\n" +
        "    {\n" +
        "      \"source\": {\n" +
        "        \"id\": \"independent\",\n" +
        "        \"name\": \"Independent\"\n" +
        "      },\n" +
        "      \"author\": \"Tom Murray\",\n" +
        "      \"title\": \"'I do not trust her': Brian Cox rips into Liz Truss on Question Time - The Independent\",\n" +
        "      \"description\": \"‘She’s the wrong person for the job,’ ‘Succession’ star asserted\",\n" +
        "      \"url\": \"https://www.independent.co.uk/arts-entertainment/tv/news/brian-cox-question-time-piers-morgan-liz-truss-b2197510.html\",\n" +
        "      \"urlToImage\": \"https://static.independent.co.uk/2022/10/06/23/Collage%20Maker-06-Oct-2022-03.21-PM.jpg?quality=75&width=1200&auto=webp\",\n" +
        "      \"publishedAt\": \"2022-10-07T04:24:15Z\",\n" +
        "      \"content\": \"Brian Cox took aim at Liz Truss on Question Time Thursday (6 October) night.\\r\\nThe actor known for playing the sharp-tongued patriarch Logan Roy on HBOs Succession appeared alongside Piers Morgan, Cha… [+1736 chars]\"\n" +
        "    },\n" +
        "    {\n" +
        "      \"source\": {\n" +
        "        \"id\": \"financial-times\",\n" +
        "        \"name\": \"Financial Times\"\n" +
        "      },\n" +
        "      \"author\": \"John Plender\",\n" +
        "      \"title\": \"Time for investors to learn a new game - Financial Times\",\n" +
        "      \"description\": \"In inflationary times, buy property, consider green investments and delay retirement\",\n" +
        "      \"url\": \"https://www.ft.com/content/5acbbfd1-9077-4641-9c74-0f8d2dcf2cea\",\n" +
        "      \"urlToImage\": \"https://www.ft.com/__origami/service/image/v2/images/raw/https%3A%2F%2Fd1e00ek4ebabms.cloudfront.net%2Fproduction%2F527b329a-8abb-4c24-b02e-1d9ced0dc64f.jpg?source=next-opengraph&fit=scale-down&width=900\",\n" +
        "      \"publishedAt\": \"2022-10-07T04:00:56Z\",\n" +
        "      \"content\": \"The times are seriously out of joint. That much is clear from the recent turmoil in the market for UK government bonds and the gyrations of sterling.\\r\\nThese febrile events followed Chancellor Kwasi K… [+12764 chars]\"\n" +
        "    },\n" +
        "    {\n" +
        "      \"source\": {\n" +
        "        \"id\": null,\n" +
        "        \"name\": \"Sky.com\"\n" +
        "      },\n" +
        "      \"author\": \"Sky\",\n" +
        "      \"title\": \"New oil and gas licensing will boost economy and energy security, says Jacob Rees-Mogg - Sky News\",\n" +
        "      \"description\": \"\",\n" +
        "      \"url\": \"https://news.sky.com/story/new-oil-and-gas-licensing-will-boost-economy-and-energy-security-says-jacob-rees-mogg-12714100\",\n" +
        "      \"urlToImage\": \"https://e3.365dm.com/22/09/1600x900/skynews-oil-rig-north-sea-oil_5914105.jpg?20220929134859\",\n" +
        "      \"publishedAt\": \"2022-10-07T03:27:58Z\",\n" +
        "      \"content\": \"Jacob Rees-Mogg has insisted a new licensing round for oil and gas exploration will boost the UK's economy and energy security.\\r\\nSpeaking as the North Sea Transition Authority (NSTA) began the 33rd r… [+4182 chars]\"\n" +
        "    },\n" +
        "    {\n" +
        "      \"source\": {\n" +
        "        \"id\": null,\n" +
        "        \"name\": \"Express\"\n" +
        "      },\n" +
        "      \"author\": \"Charlotte McIntyre\",\n" +
        "      \"title\": \"'Never happen' Royal expert details reason why Prince Harry will never return to UK - Express\",\n" +
        "      \"description\": \"Royal expert Valentine Low, author of Courtiers: The Hidden Power Behind the Crown, explained the reason why Prince Harry will never return to the UK during an appearance on Piers Morgan's TalkTV show.\",\n" +
        "      \"url\": \"https://www.express.co.uk/showbiz/tv-radio/1679372/Royal-expert-Prince-Harry-never-return-UK-children-meghan-markle\",\n" +
        "      \"urlToImage\": \"https://cdn.images.express.co.uk/img/dynamic/20/1200x712/4326591.jpg?r=1665097364835\",\n" +
        "      \"publishedAt\": \"2022-10-07T00:00:00Z\",\n" +
        "      \"content\": \"Valentine Low joined Piers Morgan on Thursday’s TalkTV show alongside panellists Isabel Oakeshott and Kevin Maguire to discuss The Times journalist's bombshells in his latest book. Isabel questioned … [+2040 chars]\"\n" +
        "    },\n" +
        "    {\n" +
        "      \"source\": {\n" +
        "        \"id\": \"independent\",\n" +
        "        \"name\": \"Independent\"\n" +
        "      },\n" +
        "      \"author\": \"Andy Gregory\",\n" +
        "      \"title\": \"Top 20 Covid hotspots as cases rise - see infections in your area - The Independent\",\n" +
        "      \"description\": \"Infections and hospitalisations at their ‘highest level in months’ after ‘concerning’ rise, says UKHSA expert\",\n" +
        "      \"url\": \"https://www.independent.co.uk/news/health/covid-hotspots-cases-rising-uk-b2197441.html\",\n" +
        "      \"urlToImage\": \"https://static.independent.co.uk/2022/09/30/18/SEI114184843.jpg?quality=75&width=1200&auto=webp\",\n" +
        "      \"publishedAt\": \"2022-10-06T23:21:57Z\",\n" +
        "      \"content\": \"Coronavirus cases are once again rising in the UK, with hospital infections in England having soared by more than a third in a week.\\r\\nOne in 65 people in England equating to more than 850,000 people … [+3925 chars]\"\n" +
        "    },\n" +
        "    {\n" +
        "      \"source\": {\n" +
        "        \"id\": \"techradar\",\n" +
        "        \"name\": \"TechRadar\"\n" +
        "      },\n" +
        "      \"author\": null,\n" +
        "      \"title\": \"Google Pixel 7 Pro hands-on: the best phone ever, says Google - TechRadar\",\n" +
        "      \"description\": \"Google aims to take the smartphone crown\",\n" +
        "      \"url\": \"https://www.techradar.com/reviews/google-pixel-7-pro\",\n" +
        "      \"urlToImage\": \"https://cdn.mos.cms.futurecdn.net/yyQwiAtAKuQQaSs4wKgEyC-1200-80.jpg\",\n" +
        "      \"publishedAt\": \"2022-10-06T22:25:53Z\",\n" +
        "      \"content\": \"It's finally here: the Google Pixel 7 Pro, a phone that Google announced almost half a year ago at its Google I/O show, leaving us wondering what could be so great about this device that Google would… [+11075 chars]\"\n" +
        "    },\n" +
        "    {\n" +
        "      \"source\": {\n" +
        "        \"id\": null,\n" +
        "        \"name\": \"Daily Mail\"\n" +
        "      },\n" +
        "      \"author\": \"Alison Boshoff\",\n" +
        "      \"title\": \"New book claims Mick Jagger slept with two members of the Rolling Stones including Keith Richards - Daily Mail\",\n" +
        "      \"description\": \"A new book suggests that Rolling Stone Mick Jagger is not just a legendary ladies' man. He's also dallied with more men than is popularly realised ...allegedly including TWO members of his own band,\",\n" +
        "      \"url\": \"https://www.dailymail.co.uk/tvshowbiz/article-11288995/New-book-claims-Mick-Jagger-slept-two-members-Rolling-Stones-including-Keith-Richards.html\",\n" +
        "      \"urlToImage\": \"https://i.dailymail.co.uk/1s/2022/10/06/21/63197269-0-image-a-10_1665086456355.jpg\",\n" +
        "      \"publishedAt\": \"2022-10-06T21:00:46Z\",\n" +
        "      \"content\": \"He's famous for being one of the most voracious and faithless men in rocknroll, and has romanced some of the worlds most desirable women, including Jerry Hall, Marianne Faithfull, Anita Pallenberg an… [+12236 chars]\"\n" +
        "    }\n" +
        "  ]\n" +
        "}"