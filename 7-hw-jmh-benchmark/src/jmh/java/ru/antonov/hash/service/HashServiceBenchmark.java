package ru.antonov.hash.service;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;
import ru.antonov.service.impl.Md5HashService;
import ru.antonov.service.impl.Sha256HashService;
import ru.antonov.service.impl.Sha512HashService;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.All)
@Fork(value = 1, warmups = 0)
@Warmup(iterations = 1, time = 2)
@Measurement(iterations = 5, time = 2)
public class HashServiceBenchmark {

    Md5HashService md5HashService;
    Sha256HashService sha256HashService;
    Sha512HashService sha512HashService;

    @Setup(Level.Trial)
    public void init() {
        try {
            md5HashService = new Md5HashService(MessageDigest.getInstance("MD5"));
            sha256HashService = new Sha256HashService(MessageDigest.getInstance("SHA256"));
            sha512HashService = new Sha512HashService(MessageDigest.getInstance("SHA512"));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    @State(Scope.Benchmark)
    public static class ExecutionPlan {
        @Param({"asdqwe", "asdpokas2!2.,pfjiapj324asijd"})
        public String pass;
    }

    @Benchmark
    public void HashServiceMd5(ExecutionPlan plan, Blackhole bh) {
        final var hash = md5HashService.hash(plan.pass);
        bh.consume(hash);
    }

    @Benchmark
    public void HashServiceSha256(ExecutionPlan plan, Blackhole bh) {
        final var hash = sha256HashService.hash(plan.pass);
        bh.consume(hash);
    }

    @Benchmark
    public void HashServiceSha512(ExecutionPlan plan, Blackhole bh) {
        final var hash = sha512HashService.hash(plan.pass);
        bh.consume(hash);
    }
}
