FROM gradle:jdk21-graal-jammy AS builder
WORKDIR /build
COPY . /build
RUN gradle nativeCompile

FROM ubuntu:jammy
COPY --from=builder /build/build/native/nativeCompile app
ENTRYPOINT ["/app/4-hw-graalvm"]
