package com.einao.marvelcomics.app.provider;

import com.einao.marvelcomics.domain.threads.ThreadManager;
import com.einao.marvelcomics.domain.usecases.ComicsUseCase;

public class UseCaseProvider {

    ThreadManager threadManager;
    RepositoryProvider repositoryProvider;

    public UseCaseProvider(ThreadManager threadManager, RepositoryProvider repositoryProvider) {
        this.threadManager = threadManager;
        this.repositoryProvider = repositoryProvider;
    }

    public ComicsUseCase getComicsUseCase() {
        return new ComicsUseCase(threadManager, repositoryProvider.getComicRepository());
    }

}
