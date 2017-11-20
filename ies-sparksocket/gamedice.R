n <- 6 #Posible outcomes
r <- 3 #Number experiments

v1 <- rep(c(sapply(seq(1:n), function(z){rep(z,n^(r-1))})),n^(r-3))
v2 <- rep(c(sapply(seq(1:n), function(z){rep(z,n^(r-2))})),n^(r-2))
v3 <- rep(c(sapply(seq(1:n), function(z){rep(z,n^(r-3))})),n^(r-1))
V <- rbind(v1,v2,v3)

initSeed <- function() {
	entropy <- file('/dev/urandom', 'rb')
	linux_seed <- readBin(entropy, 1L)
	set.seed(linux_seed, "Mersenne-Twister")
	close(entropy)
}

getData <- function() {
	index <- sample(seq(1:n^r),1)
	temp <- v1[index]*100 + v2[index]*10 + v3[index]
	return(temp)
}

getHand <- function(){
	a<-sample(1:52)
	aux<-a[1:5]
	return(aux)
}

getGameDeck <- function(){
	a<-sample(1:52)
	aux<-a[1:10]
	return(aux)
}

getDeck <- function(){
	return(sample(1:52))
}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
