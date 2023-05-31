package com.bayutb.gombti.data

@Suppress("SpellCheckingInspection")
object DataSource {
    fun getRecommendation(mbti: String): List<String> {
        val recommendation = mutableListOf<List<String>>()
        val mbtiList = listOf(
            "ISTJ",
            "ISFJ",
            "INFJ",
            "INTJ",
            "ISTP",
            "ISFP",
            "INFP",
            "INTP",
            "ESTP",
            "ESFP",
            "ENFP",
            "ENTP",
            "ESTJ",
            "ESFJ",
            "ENFJ",
            "ENTJ"
        )
        val allRecommendation = listOf(
            listOf(
                "Membuat jadwal belajar terstruktur: ISTJ cenderung menghargai keteraturan dan struktur. Buat jadwal belajar yang terstruktur dan ikuti dengan disiplin.",
                "Fokus pada detail dan fakta: ISTJ memiliki kecenderungan kuat untuk memperhatikan detail dan fakta. Fokus pada pemahaman yang mendalam tentang konsep dan menguasai detail-detail penting",
                "Menggunakan metode belajar tradisional: ISTJ cenderung cocok dengan metode belajar yang terstruktur, seperti membaca teks, membuat catatan, dan melakukan latihan secara sistematis.",
                "Membuat daftar tugas dan checklist: Gunakan daftar tugas dan checklist untuk mengatur pekerjaan yang harus dilakukan dan memastikan tidak ada yang terlewat.",
                "Memanfaatkan sumber daya yang terpercaya: ISTJ lebih suka mengandalkan sumber daya yang terpercaya dan teks bahan ajar yang resmi. Gunakan buku, jurnal akademik, atau sumber daya terpercaya lainnya untuk memperdalam pemahaman.",
                "Menggunakan pendekatan step-by-step: ISTJ cenderung menghargai pendekatan bertahap dan langkah-demi-langkah. Terapkan pendekatan ini dalam belajar, memecah materi yang kompleks menjadi bagian-bagian yang lebih kecil.",
                "Evaluasi secara objektif: Lakukan evaluasi diri secara objektif untuk mengidentifikasi kekuatan dan kelemahan Anda. Fokus pada perbaikan dan memperkuat kelemahan Anda.",
                "Membuat ringkasan dan diagram: Gunakan ringkasan dan diagram untuk mengorganisir informasi dan memvisualisasikan hubungan antara konsep."
            ),
            listOf(
                "Menciptakan lingkungan belajar yang nyaman: ISFJ cenderung belajar dengan baik dalam lingkungan yang nyaman dan tenang. Ciptakan tempat belajar yang bebas dari gangguan dan nyaman bagi Anda.",
                "Mengandalkan metode belajar tradisional: ISFJ cenderung cocok dengan metode belajar yang terstruktur dan berbasis pada teks, seperti membaca buku teks, membuat catatan, dan melibatkan diri dalam latihan.",
                "Menggunakan pengulangan dan mempraktikkan materi: Gunakan pengulangan dalam mempelajari materi dan praktikkan dengan menjawab soal latihan atau mengulangi konsep secara teratur.",
                "Membuat catatan dan daftar tugas: Buat catatan yang rapi dan teratur saat belajar dan gunakan daftar tugas untuk mengatur pekerjaan yang harus diselesaikan.",
                "Mencari kejelasan dan petunjuk yang jelas: ISFJ cenderung menghargai kejelasan dan petunjuk yang jelas. Pastikan Anda memahami dengan baik instruksi atau materi yang dipelajari.",
                "Terlibat dalam pembelajaran praktis: Terapkan materi yang dipelajari dalam situasi praktis atau contoh nyata untuk memperkuat pemahaman dan menghubungkannya dengan kehidupan sehari-hari.",
                "Kolaborasi dalam kelompok belajar: Diskusikan materi dengan orang lain dalam kelompok belajar untuk mendapatkan wawasan baru dan saling mendukung dalam pemahaman.",
                "Menghargai kejujuran dan integritas dalam belajar: ISFJ cenderung menghargai nilai-nilai moral dan etika. Tetaplah jujur dalam belajar dan menghindari tindakan plagiat atau kecurangan."
            ),
            listOf(
                "Membuat waktu dan ruang yang tenang: Ciptakan lingkungan belajar yang tenang dan minim gangguan untuk membantu konsentrasi dan refleksi.",
                "Pendekatan holistik: INFJ cenderung melihat hubungan dan pola dalam informasi. Gunakan pendekatan holistik dalam belajar dengan mencari kaitan antara konsep-konsep yang dipelajari.",
                "Manfaatkan pemahaman empati: INFJ memiliki kemampuan empati yang kuat. Manfaatkan kemampuan ini dengan mencoba memahami perspektif orang lain dalam materi yang dipelajari.",
                "Gunakan teknik visual: Gunakan diagram, grafik, atau mind map untuk membantu memvisualisasikan dan memahami konsep-konsep yang kompleks.",
                "Ciptakan waktu untuk refleksi: INFJ cenderung suka merenung dan memproses informasi secara mendalam. Berikan waktu untuk merenungkan dan mengaitkan pemahaman Anda dalam catatan atau jurnal.",
                "Diskusi dalam kelompok kecil: Diskusikan materi dengan kelompok kecil teman sekelas atau belajar secara satu-satu untuk mendapatkan perspektif baru dan memperdalam pemahaman Anda.",
                "Terapkan nilai-nilai pribadi dalam belajar: INFJ cenderung memiliki sistem nilai yang kuat. Terapkan nilai-nilai pribadi Anda dalam memilih topik studi atau proyek yang mencerminkan minat dan tujuan hidup Anda.",
                "Jaga keseimbangan antara teori dan praktik: Sebagai pemikir intuitif, INFJ perlu menghubungkan konsep-konsep teoritis dengan aplikasi praktis dalam dunia nyata. Temukan cara untuk mengaitkan apa yang dipelajari dengan contoh atau situasi praktis."
            ),
            listOf(
                "Buat rencana belajar terstruktur: Buat jadwal belajar yang terperinci dan ikuti rencana yang telah ditentukan.",
                "Pelajari konsep secara mendalam: Fokus pada pemahaman konsep-konsep dengan analisis kritis dan hubungan antara konsep-konsep tersebut.",
                "Pilih sumber belajar yang menantang: Gunakan sumber belajar yang memerlukan pemikiran kritis dan menawarkan perspektif baru atau pemecahan masalah kompleks.",
                "Gunakan metode visualisasi: Gunakan diagram, grafik, atau mind map untuk memvisualisasikan hubungan antara konsep-konsep yang dipelajari.",
                "Berdiskusi dan berkolaborasi dengan orang lain: Diskusikan ide-ide dan konsep-konsep dengan teman sekelas, rekan kerja, atau forum online untuk mendapatkan wawasan baru.",
                "Luangkan waktu untuk refleksi: Setelah belajar, luangkan waktu sendiri untuk merenungkan materi yang dipelajari dan mencoba menerapkannya dalam konteks yang berbeda.",
                "Berikan diri tantangan: Berikan diri tugas atau proyek yang menantang untuk mengembangkan keterampilan dan pengetahuan.",
                "Istirahat yang cukup: Berikan waktu istirahat yang cukup untuk merenung dan mengisi ulang energi."
            ),
            listOf(
                "Belajar dengan praktek langsung: ISTP cenderung belajar lebih baik melalui pengalaman langsung. Terlibat dalam aktivitas praktis, eksperimen, atau proyek yang memungkinkan Anda menerapkan konsep dalam situasi nyata.",
                "Menggunakan metode belajar visual dan praktis: Gunakan visualisasi, diagram, atau model fisik untuk membantu memahami konsep. Gunakan juga latihan praktis dan permainan untuk memperkuat pemahaman.",
                "Menghadapi tantangan dan masalah: ISTP cenderung belajar lebih baik saat dihadapkan pada tantangan dan masalah nyata. Carilah masalah atau proyek yang menarik bagi Anda, dan temukan solusinya melalui eksperimen dan analisis.",
                "Fleksibel dan beradaptasi: ISTP cenderung memiliki kecenderungan fleksibel dan adaptif. Manfaatkan kecenderungan ini dengan menyelaraskan metode belajar sesuai kebutuhan dan menjelajahi berbagai sumber daya yang berbeda.",
                "Mengambil jeda dan waktu luang: ISTP dapat membutuhkan waktu untuk beristirahat dan bersantai. Berikan diri Anda jeda yang cukup untuk merefresh pikiran sebelum kembali belajar.",
                "Mencari pemecahan masalah secara mandiri: ISTP cenderung suka mencari solusi secara mandiri. Gunakan waktu untuk berpikir secara kritis dan mengeksplorasi berbagai pendekatan dalam memecahkan masalah.",
                "Toleransi terhadap risiko dan kegagalan: ISTP cenderung lebih toleran terhadap risiko dan kegagalan. Jangan takut untuk mencoba pendekatan baru atau bereksperimen dalam belajar.",
                "Menggunakan teknologi dan sumber daya online: Manfaatkan teknologi dan sumber daya online, seperti video tutorial, forum diskusi, atau aplikasi pembelajaran interaktif, untuk mendukung pembelajaran Anda."
            ),
            listOf(
                "Pembelajaran yang berhubungan dengan perasaan: ISFP cenderung belajar lebih baik melalui pengalaman yang melibatkan emosi dan perasaan. Sambungkan materi pembelajaran dengan pengalaman pribadi, kisah, atau seni untuk memperkuat pemahaman.",
                "Menggunakan metode belajar yang kreatif: Gunakan pendekatan kreatif dalam belajar, seperti seni visual, musik, drama, atau menulis. Gunakan pengalaman seni untuk menggambarkan konsep dan memperluas pemahaman.",
                "Menciptakan lingkungan belajar yang nyaman: Ciptakan lingkungan belajar yang menenangkan dan nyaman. Pilih tempat yang tenang, penuh dengan inspirasi, dan sesuai dengan preferensi sensorik Anda.",
                "Belajar melalui pengamatan dan pengalaman langsung: Amati dunia sekitar Anda dan ambil pelajaran dari pengalaman langsung. Libatkan diri dalam kegiatan lapangan, eksplorasi alam, atau perjalanan untuk memperkaya pemahaman Anda.",
                "Berkolaborasi dengan teman sekelas atau mentor: Diskusikan materi dengan teman sekelas atau minta bantuan mentor. Diskusi dan interaksi dengan orang lain dapat membantu Anda memperoleh wawasan baru dan memperdalam pemahaman.",
                "Menggunakan metode belajar reflektif: Sisihkan waktu untuk merenungkan materi yang dipelajari. Tulis jurnal, buat catatan reflektif, atau bermeditasi untuk menggali pemahaman yang lebih dalam.",
                "Menerima variasi dan kebebasan dalam belajar: ISFP cenderung menghargai kebebasan dan variasi dalam belajar. Gunakan metode yang beragam, mencoba pendekatan baru, dan pilih mata pelajaran yang menarik minat Anda.",
                "Mengenali emosi dan kebutuhan diri sendiri: Sadari emosi dan kebutuhan pribadi Anda saat belajar. Berikan waktu untuk self-care dan memperhatikan keseimbangan antara belajar dan kegiatan lain yang memberi Anda kebahagiaan."
            ),
            listOf(
                "Menciptakan lingkungan belajar yang nyaman: INFP cenderung bekerja lebih baik dalam lingkungan yang nyaman dan mendukung. Ciptakan tempat belajar yang tenang, nyaman, dan inspiratif.",
                "Menyelaraskan belajar dengan nilai-nilai pribadi: INFP memiliki nilai-nilai yang kuat dan ingin belajar yang berarti. Pilih topik atau materi yang sesuai dengan minat dan nilai-nilai Anda.",
                "Gunakan pendekatan kreatif dan artistik: INFP sering memiliki kecenderungan kreatif. Gunakan metode belajar yang melibatkan aspek artistik, seperti membuat ilustrasi, menulis puisi, atau membuat catatan yang indah.",
                "Pemanfaatan pemikiran reflektif: INFP cenderung memiliki pemikiran reflektif yang dalam. Manfaatkan waktu untuk merenung, memproses informasi, dan membuat koneksi pribadi dengan apa yang dipelajari.",
                "Diskusi dalam kelompok kecil atau dengan mitra belajar: Diskusikan materi dengan orang lain, terutama dengan mereka yang memiliki minat dan pandangan sejalan, untuk memperluas wawasan dan mendapatkan perspektif baru.",
                "Menulis dan menyusun catatan pribadi: INFP sering menyukai tulisan dan pemrosesan melalui kata-kata. Tulis dan susun catatan pribadi yang menggambarkan pemahaman dan refleksi pribadi Anda terhadap materi yang dipelajari.",
                "Ambil waktu untuk eksplorasi mandiri: INFP cenderung suka menggali topik secara mendalam. Berikan waktu untuk belajar secara mandiri, mengeksplorasi sumber daya yang berbeda, dan mengikuti minat pribad.",
                "Jaga keseimbangan antara kebebasan dan struktur: INFP menghargai kreativitas dan kebebasan dalam belajar, tetapi juga dapat membutuhkan sedikit struktur. Temukan keseimbangan antara kebebasan eksplorasi dan kebutuhan untuk mengikuti jadwal atau rencana yang terstruktur."
            ),
            listOf(
                "Eksplorasi bebas: Biarkan diri Anda mengeksplorasi topik dengan bebas tanpa terlalu terikat pada struktur yang ketat.",
                "Pendekatan logis dan analitis: Gunakan pendekatan logika dan analisis dalam memahami konsep-konsep secara mendalam.",
                "Manfaatkan teknologi dan sumber daya online: Gunakan teknologi dan sumber daya online seperti video tutorial dan forum diskusi untuk mendapatkan informasi tambahan dan berinteraksi dengan orang lain.",
                "Diskusikan ide-ide dengan orang lain: Diskusikan konsep-konsep dengan orang lain untuk mendapatkan sudut pandang baru dan melatih kemampuan verbal.",
                "Merenung secara mandiri: Berikan waktu untuk merenungkan konsep-konsep secara mendalam dan tuliskan pemikiran Anda dalam bentuk catatan atau jurnal.",
                "Beri diri tantangan intelektual: Cari tugas atau proyek yang menantang di luar kurikulum standar untuk mengembangkan keterampilan dan pengetahuan Anda.",
                "Eksperimen dan terima kesalahan: Coba pendekatan belajar yang berbeda dan jangan takut membuat kesalahan, lihatlah sebagai kesempatan untuk belajar dan berkembang.",
                "Terbuka terhadap perubahan: Tetap terbuka terhadap pemikiran baru dan revisi pemahaman Anda jika ada bukti atau sudut pandang yang berbeda."
            ),
            listOf(
                "Pembelajaran yang aktif dan praktis: ESTP cenderung belajar lebih baik melalui kegiatan yang praktis dan interaktif. Terlibat dalam diskusi, eksperimen, simulasi, atau proyek nyata untuk memperkuat pemahaman.",
                "Menggunakan metode belajar yang beragam: Gunakan metode belajar yang beragam, seperti video, presentasi, diskusi kelompok, atau aplikasi pembelajaran interaktif. Variasi dalam metode dapat membantu mempertahankan minat dan keterlibatan.",
                "Menciptakan tantangan dan tujuan yang jelas: ESTP cenderung termotivasi oleh tantangan dan tujuan yang jelas. Tetapkan tujuan belajar yang spesifik dan tantang diri Anda sendiri untuk mencapainya.",
                "Belajar melalui pengalaman langsung: Ambil bagian dalam pengalaman langsung, seperti magang, kerja praktek, atau proyek lapangan yang relevan dengan materi pelajaran. Pengalaman praktis akan membantu Anda memahami dan mengaitkan konsep dengan dunia nyata.",
                "Mencari kesempatan untuk berdiskusi dan berkolaborasi: Diskusikan materi dengan teman sekelas atau bergabung dengan kelompok belajar. Diskusi dan kolaborasi memungkinkan Anda mendapatkan sudut pandang yang berbeda dan memperdalam pemahaman.",
                "Menggunakan teknologi dan sumber daya digital: Manfaatkan teknologi dan sumber daya digital dalam pembelajaran. Gunakan aplikasi, video tutorial, atau platform pembelajaran online untuk mendapatkan informasi dan sumber daya tambahan.",
                "Mengatur waktu belajar yang fleksibel: ESTP cenderung suka fleksibilitas dan kebebasan dalam mengatur waktu. Aturlah jadwal belajar yang sesuai dengan gaya hidup Anda dan manfaatkan waktu luang yang efektif.",
                "Mencari kegiatan fisik dan olahraga: Melibatkan diri dalam kegiatan fisik atau olahraga dapat membantu ESTP mengurangi kegelisahan dan meningkatkan fokus saat belajar."
            ),
            listOf(
                "Pembelajaran yang melibatkan emosi: ESFP cenderung belajar lebih baik melalui pengalaman yang melibatkan emosi dan perasaan. Sambungkan materi pembelajaran dengan pengalaman pribadi, kisah, atau seni untuk memperkuat pemahaman.",
                "Aktivitas belajar yang kreatif: Gunakan pendekatan kreatif dalam belajar, seperti seni visual, musik, tarian, atau permainan peran. Gunakan kreativitas Anda untuk menggambarkan konsep dan memperluas pemahaman.",
                "Lingkungan belajar yang nyaman: Ciptakan lingkungan belajar yang menenangkan dan nyaman. Pilih tempat yang ramai, penuh warna, dan sesuai dengan preferensi sensorik Anda.",
                "Interaksi sosial dalam belajar: ESFP cenderung belajar melalui interaksi sosial. Diskusikan materi dengan teman sekelas, bergabung dengan kelompok belajar, atau gunakan metode kolaboratif untuk memperdalam pemahaman.",
                "Belajar melalui pengalaman langsung: Ambil bagian dalam kegiatan praktis dan pengalaman langsung yang relevan dengan materi. Terlibat dalam eksperimen, proyek lapangan, atau magang untuk memperkaya pemahaman Anda.",
                "Menggunakan teknologi dan multimedia: Manfaatkan teknologi dan sumber daya multimedia dalam pembelajaran. Gunakan video, audio, atau aplikasi pembelajaran interaktif untuk memperkaya pengalaman belajar Anda.",
                "Mengatur waktu belajar yang fleksibel: ESFP cenderung suka fleksibilitas dan spontanitas. Aturlah jadwal belajar yang sesuai dengan gaya hidup Anda dan manfaatkan waktu luang yang efektif.",
                "Penghargaan terhadap prestasi dan keberagaman: Berikan penghargaan pada diri sendiri saat mencapai tujuan belajar. Selain itu, eksplorasi keberagaman topik dan metode belajar untuk menjaga minat dan motivasi."
            ),
            listOf(
                "Eksplorasi beragam topik: ENFP cenderung tertarik pada banyak hal. Eksplorasi berbagai topik yang menarik bagi Anda untuk memperluas pengetahuan dan mempertahankan minat.",
                "Diskusi dengan orang lain: Diskusikan materi dengan orang lain untuk mendapatkan wawasan baru, mendebat ide-ide, dan melihat perspektif yang berbeda.",
                "Kreativitas dalam pembelajaran: Gunakan kreativitas dalam cara Anda mempelajari materi, seperti membuat visualisasi, menggambar mind map, atau membuat lagu atau puisi untuk mengingat informasi.",
                "Pemanfaatan teknologi dan sumber daya online: Gunakan teknologi dan sumber daya online untuk mendapatkan akses ke informasi yang beragam dan terkini.",
                "Terlibat dalam pembelajaran praktis: Coba aplikasikan materi yang dipelajari dalam proyek praktis, simulasi, atau situasi nyata untuk meningkatkan pemahaman dan pengalaman praktis.",
                "Mengatasi tugas yang menantang: Cari tugas yang menantang di luar kurikulum untuk mempertahankan minat dan mendorong pertumbuhan intelektual.",
                "Kelompok belajar atau studi kelompok: Terlibat dalam kelompok belajar atau studi kelompok dengan orang-orang yang memiliki minat serupa untuk saling mendukung dan memperdalam pemahaman.",
                "Refleksi dan evaluasi diri: Lakukan refleksi dan evaluasi diri secara teratur untuk melihat kemajuan belajar Anda, mengidentifikasi kekuatan dan kelemahan, dan membuat perbaikan yang diperlukan."
            ),
            listOf(
                "Eksplorasi dan variasi topik: Mengeksplorasi berbagai topik yang menarik bagi Anda untuk memperluas pengetahuan.",
                "Diskusi dan berdebat: Berdiskusi dengan orang lain untuk mendapatkan wawasan baru dan melatih pemikiran kritis.",
                "Pemanfaatan teknologi dan sumber daya online: Gunakan teknologi dan sumber daya online untuk akses informasi yang beragam.",
                "Pendekatan kreatif dan inovatif: Gunakan metode kreatif seperti mind map atau gambar untuk memahami konsep.",
                "Terlibat dalam diskusi kelompok atau proyek kolaboratif: Terlibat dalam diskusi kelompok dan proyek kolaboratif untuk memperluas pemahaman.",
                "Beri diri tantangan intelektual: Cari tugas yang menantang di luar kurikulum untuk mengembangkan pemikiran kritis.",
                "Jaga fleksibilitas dan adaptabilitas: Bersikap fleksibel dan adaptif terhadap perubahan.",
                "Evaluasi dan refleksi secara teratur: Lakukan evaluasi diri untuk melihat kemajuan belajar dan perbaiki area yang perlu ditingkatkan."
            ),
            listOf(
                "Membuat jadwal belajar yang terstruktur: ESTJ cenderung menghargai keteraturan dan struktur. Buat jadwal belajar yang terstruktur dan patuhi dengan disiplin.",
                "Menggunakan metode belajar yang praktis: ESTJ cenderung belajar melalui pengalaman praktis. Terlibatlah dalam latihan, proyek-proyek, atau simulasi yang memungkinkan Anda menerapkan konsep dalam situasi nyata.",
                "Menggunakan sumber daya resmi dan teks bahan ajar: ESTJ cenderung mengandalkan sumber daya yang resmi dan teks bahan ajar. Gunakan buku teks, materi ajar yang terpercaya, dan sumber daya online yang terverifikasi.",
                "Melibatkan diri dalam diskusi dan perdebatan: Diskusikan materi dengan orang lain, ikuti perdebatan, atau bergabung dalam kelompok studi untuk mendapatkan wawasan baru dan mempertajam pemahaman.",
                "Menggunakan metode visual dan diagram: Gunakan visualisasi, diagram, atau peta konsep untuk membantu memahami hubungan antara konsep-konsep yang kompleks.",
                "Mengikuti aturan dan petunjuk dengan seksama: ESTJ cenderung menghargai aturan dan petunjuk yang jelas. Pastikan Anda memahami dan mengikuti instruksi dengan seksama.",
                "Membuat catatan yang sistematis: Buat catatan yang rapi dan terstruktur saat belajar. Ini membantu Anda memperjelas dan mengingat informasi dengan lebih baik.",
                "Mengevaluasi kemajuan secara objektif: Lakukan evaluasi diri secara objektif untuk melihat kemajuan belajar Anda dan mengidentifikasi area yang perlu diperbaiki. Tetapkan tujuan yang jelas dan ukur kemajuan Anda secara teratur."
            ),
            listOf(
                "Pembelajaran melalui interaksi sosial: ESFJ cenderung belajar melalui interaksi dengan orang lain. Bergabung dengan kelompok belajar, diskusikan materi dengan teman sekelas, atau minta bantuan dari mentor untuk memperdalam pemahaman.",
                "Metode belajar yang terstruktur: Gunakan metode belajar yang terstruktur, seperti membuat jadwal belajar, mengorganisasi catatan, atau menggunakan sistem catatan yang teratur. Rencanakan langkah-langkah yang jelas dalam pembelajaran.",
                "Menciptakan lingkungan belajar yang ramah: Ciptakan lingkungan belajar yang nyaman, bersih, dan ramah. Pastikan tempat belajar Anda bebas dari gangguan dan mencerminkan preferensi sensorik Anda.",
                "Menggunakan pendekatan belajar yang praktis: Terlibat dalam kegiatan praktis yang memungkinkan Anda menerapkan konsep dalam situasi nyata. Gunakan studi kasus, simulasi, atau proyek praktis untuk meningkatkan pemahaman.",
                "Memanfaatkan sumber daya dan materi yang terstruktur: Gunakan buku teks, panduan, atau sumber daya terstruktur lainnya untuk mempelajari materi secara sistematis dan terarah.",
                "Merencanakan waktu belajar dengan baik: Buat jadwal belajar yang teratur dan konsisten. Aturlah waktu yang cukup untuk setiap topik atau tugas yang perlu dipelajari.",
                "Menggunakan catatan dan pemetaan konsep: Buat catatan yang rapi dan pemetaan konsep yang membantu Anda mengorganisasi informasi dan menghubungkan konsep yang berbeda.",
                "Menerima umpan balik dan evaluasi: Minta umpan balik dari guru atau teman sekelas untuk memperbaiki pemahaman Anda. Lakukan evaluasi secara berkala untuk mengukur kemajuan Anda."
            ),
            listOf(
                "Kolaborasi dan interaksi sosial: ENFJ cenderung belajar melalui interaksi sosial. Carilah kesempatan untuk bekerja dalam kelompok atau berdiskusi dengan orang lain untuk mendapatkan wawasan dan perspektif baru.",
                "Pemanfaatan kemampuan komunikasi: ENFJ memiliki kemampuan komunikasi yang baik. Gunakan kemampuan ini untuk menjelaskan konsep kepada orang lain atau mengajar teman sekelas yang membutuhkan bantuan.",
                "Mengaitkan materi dengan realitas: Cari cara untuk menghubungkan materi yang dipelajari dengan situasi atau contoh dalam kehidupan nyata. Ini membantu Anda memahami dan mengingat informasi dengan lebih baik.",
                "Membangun hubungan dengan dosen atau mentor: Cari dukungan dari dosen atau mentor yang dapat memberikan panduan dan saran dalam proses belajar.",
                "Menggunakan metode visual dan audio: Gunakan diagram, peta konsep, atau rekaman audio untuk membantu memvisualisasikan dan memahami konsep yang kompleks.",
                "Terlibat dalam proyek-proyek sosial: ENFJ cenderung terinspirasi oleh tujuan sosial. Terlibatlah dalam proyek-proyek yang memiliki dampak sosial atau membantu orang lain untuk menggabungkan pembelajaran dengan tujuan sosial.",
                "Mengatur jadwal yang teratur: Buat jadwal belajar yang teratur dan disiplin untuk mengelola waktu dengan efisien dan menghindari penundaan.",
                "Evaluasi dan refleksi: Lakukan evaluasi diri secara teratur untuk melihat kemajuan belajar Anda dan refleksikan apa yang telah Anda pelajari. Identifikasi area yang perlu diperbaiki dan buat rencana tindakan untuk meningkatkan pemahaman Anda."
            ),
            listOf(
                "Rencanakan belajar dengan tujuan yang jelas: Buat rencana belajar terstruktur dengan tujuan spesifik dan langkah-langkah yang terperinci.",
                "Fokus pada aplikasi praktis: Temukan cara untuk menghubungkan konsep-konsep dengan situasi dunia nyata atau contoh-contoh yang relevan.",
                "Cari sumber belajar yang efisien: Pilih sumber belajar yang ringkas, langsung ke intinya, dan memadukan informasi secara efektif.",
                "Diskusikan ide-ide dengan orang lain: Diskusikan konsep-konsep dengan orang lain untuk mendapatkan perspektif baru dan melatih kemampuan verbal.",
                "Gunakan metode pembelajaran aktif: Terlibat dalam kegiatan praktis untuk menerapkan konsep-konsep yang dipelajari.",
                "Ciptakan lingkungan belajar yang produktif: Buat area belajar yang terorganisir dan minim gangguan agar dapat fokus sepenuhnya.",
                "Ambil inisiatif dalam kelompok belajar: Berperan aktif dalam kelompok belajar, mengorganisir diskusi, dan membantu mengarahkan kelompok menuju tujuan belajar.",
                "Evaluasi dan refleksi secara teratur: Lakukan evaluasi diri untuk melihat kemajuan belajar dan temukan area yang perlu diperbaiki."
            )
        )

        when (mbti) {
            mbtiList[0] -> {
                recommendation.add(allRecommendation[0])
            }

            mbtiList[1] -> {
                recommendation.add(allRecommendation[1])
            }

            mbtiList[2] -> {
                recommendation.add(allRecommendation[2])
            }

            mbtiList[3] -> {
                recommendation.add(allRecommendation[3])
            }

            mbtiList[4] -> {
                recommendation.add(allRecommendation[4])
            }

            mbtiList[5] -> {
                recommendation.add(allRecommendation[5])
            }

            mbtiList[6] -> {
                recommendation.add(allRecommendation[6])
            }

            mbtiList[7] -> {
                recommendation.add(allRecommendation[7])
            }

            mbtiList[8] -> {
                recommendation.add(allRecommendation[8])
            }

            mbtiList[9] -> {
                recommendation.add(allRecommendation[9])
            }

            mbtiList[10] -> {
                recommendation.add(allRecommendation[10])
            }

            mbtiList[11] -> {
                recommendation.add(allRecommendation[11])
            }

            mbtiList[12] -> {
                recommendation.add(allRecommendation[12])
            }

            mbtiList[13] -> {
                recommendation.add(allRecommendation[13])
            }

            mbtiList[14] -> {
                recommendation.add(allRecommendation[14])
            }

            mbtiList[15] -> {
                recommendation.add(allRecommendation[15])
            }

            else -> {
                recommendation.add(listOf("Error MBTI Reference"))
            }

        }

        return recommendation.flatten()
    }
}