export interface TableModel {
    rowId: number;
    rowWebsite: string;
    votedThisSession: number;
    maxThreads: number;
    stopAtVotes: number;
    votingDelay: number;
    proxyTimeout: number;
    stopVoting: boolean;
    captcha: number;
    success: number;
    succesRate: number;
    shouldHaveSuccess: number;
    startTime: number;
    once: number;

}