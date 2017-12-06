package cn.xianbin.agent;

import java.lang.instrument.Instrumentation;
import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;

public class TimingAgent {

  public static void premain(String args, Instrumentation inst) {
    new AgentBuilder.Default()
        .type(ElementMatchers.any())
        .transform((builder, type, classLoader, module) ->
            builder.method(ElementMatchers.any())
                .intercept(MethodDelegation.to(TimingInterceptor.class))
        ).installOn(inst);
  }


}

