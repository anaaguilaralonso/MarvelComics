package com.einao.marvelcomics.domain.policy;

public interface DatabasePolicy {

    boolean isValid(Long lastComicsRequest) ;
}
