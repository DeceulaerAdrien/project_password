FROM amazoncorretto:25-jdk

RUN dnf update -y && \
    dnf install -y \
    bash \
    git \
    #install les décompression nécessaire a l'installation de Maven
    tar \
    gzip \
    # Installer Maven
    maven \
    && dnf clean all